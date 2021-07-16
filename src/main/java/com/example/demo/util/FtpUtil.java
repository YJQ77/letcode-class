package com.example.demo.util;

import com.example.demo.util.reconciliation.BillDto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/6/24 17:11
 */
@Component
public class FtpUtil {

    private final static String sourcePath = "D:\\temp";
    private final static String separator = "/";
    private final static String tempFileName = "buchuan.txt";
    private final static String result = "result";

    @Value("${ftp.url}")
    private String url;
    @Value("${ftp.port}")
    private int port;
    @Value("${ftp.username}")
    private String username;
    @Value("${ftp.password}")
    private String password;
    @Value("${ftp.prefix}")
    private String prefix;

    private FTPClient ftpClient = null;

    @PostConstruct
    public void init() {
        ftpClient = getFTPClient(url, port, username, password);
    }

    @PreDestroy
    public void destroy() {
        disConnection(ftpClient);
    }


    /**
     * 打开FTP服务链接
     *
     * @param ftpHost
     * @param ftpPort
     * @param ftpUserName
     * @param ftpPassword
     */
    public FTPClient getFTPClient(String ftpHost, Integer ftpPort, String ftpUserName, String ftpPassword) {
        FTPClient ftpClient = null;
        try {
            ftpClient = new FTPClient();
            ftpClient.setConnectTimeout(60000);
            ftpClient.connect(ftpHost, ftpPort);// 连接FTP服务器
            if (FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                if (ftpClient.login(ftpUserName, ftpPassword)) {// 登陆FTP服务器
                    if (FTPReply.isPositiveCompletion(ftpClient.sendCommand(
                            "OPTS UTF8", "ON"))) {// 开启服务器对UTF-8的支持，如果服务器支持就用UTF-8编码，否则就使用本地编码（GBK）.
                        ftpClient.setControlEncoding("UTF-8");
                    } else {
                        ftpClient.setControlEncoding("GBK");
                    }
                    ftpClient.enterLocalPassiveMode();// 设置被动模式
                    ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);// 设置传输的模式，以二进制流的方式读取
                    ftpClient.enterLocalPassiveMode();
                    System.out.println("FTP服务连接成功！");
                } else {
                    System.out.println("FTP服务用户名或密码错误！");
                    disConnection(ftpClient);
                }
            } else {
                System.out.println("连接到FTP服务失败！");
                disConnection(ftpClient);
            }
        } catch (SocketException e) {
            e.printStackTrace();
            disConnection(ftpClient);
            System.out.println("FTP的IP地址可能错误，请正确配置。");
        } catch (IOException e) {
            e.printStackTrace();
            disConnection(ftpClient);
            System.out.println("FTP的端口错误,请正确配置。");
        }
        return ftpClient;
    }

    /**
     * 关闭FTP服务链接
     *
     * @throws IOException
     */
    public void disConnection(FTPClient ftpClient) {
        try {
            if (ftpClient.isConnected()) {
                ftpClient.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据路径获取待对账的票据txt文件信息
     *
     * @param path
     * @return
     */
    public FTPFile[] getFtpFiles(String path) {
        path = prefix + path;
        FTPFile[] files = null;
        try {
            String s = ftpClient.printWorkingDirectory();
            System.out.println(s);
            ftpClient.changeWorkingDirectory(new String(path.getBytes(ftpClient.getControlEncoding()), "iso-8859-1"));
            files = ftpClient.listFiles();
        } catch (IOException e) {

        }
        return files;
    }

    /**
     * 解析txt文件 转化为dto
     *
     * @param path
     * @return
     */
    public List<BillDto> getFileByPath(String path) {
        BufferedReader reader = null;//字符输入流进行读取操作读取
        String tempString = null;//每一行的内容
        InputStream intput = null;
        List<BillDto> list = new ArrayList<>();
        try {
            FTPFile[] files = getFtpFiles(path);
            BillDto dto = null;
            for (FTPFile ftpFile : files) {
                if (ftpFile.isFile()) {
                    intput = ftpClient.retrieveFileStream(ftpFile.getName());
                    reader = new BufferedReader(new InputStreamReader(intput));
                    while ((tempString = reader.readLine()) != null) {
                        String[] split = tempString.split("\\|\\|");
                        dto = new BillDto(split[0].trim(), split[1].trim(), Integer.parseInt(split[2].trim()),
                                split[3].trim(), split[4].trim(), split[5].trim(), split[6].trim(),
                                split[7].trim(), split[8].trim(), split[9].trim());
                        list.add(dto);
                    }
                    intput.close();
                    //ftp传输结束
                    ftpClient.completePendingCommand();
                }
            }
        } catch (IOException e) {

        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (intput != null) {
                    intput.close();
                }
            } catch (IOException e) {
            }
        }
        return list;
    }

    /**
     * 将对账失败的票据信息txt文件上传到ftp
     *
     * @param areaCode
     * @param date
     */
    public void uploadBuChuan(String areaCode, String date) {
        String targetPath = prefix + areaCode + separator + date;
        InputStream in = null;
        String filePath = sourcePath;
        String fileName = tempFileName;
        File file = new File(filePath + File.separator + fileName);
        try {
            in = new FileInputStream(file);
            //创建多级目录
            ftpClient.changeWorkingDirectory(new String(targetPath.getBytes(ftpClient.getControlEncoding()), "iso-8859-1"));
            ftpClient.makeDirectory(result);
            ftpClient.changeWorkingDirectory(result);
            //上传到ftp
            ftpClient.storeFile(new String((date + "-result.txt").getBytes(ftpClient.getControlEncoding()), "iso-8859-1"), in);
        } catch (IOException e) {

        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ioe) {

            }
        }
    }

    /**
     * 将对账失败的票据信息写入txt文件
     *
     * @param list
     * @return
     */
    public File createTxtFile(List<BillDto> list) {
        //创建文件
        String filePath = sourcePath;
        String fileName = tempFileName;
        File file = new File(filePath + File.separator + fileName);
        //创建文件写入流，FileWriter无需指定传输字符集编码格式
        FileWriter fw = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            //如果文件存在，则追加内容；如果文件不存在，则创建文件
            fw = new FileWriter(file, true);
            for (BillDto billDto : list) {
                fw.write(billDto.getString() + "\n");
            }
            fw.close();
        } catch (IOException e) {

        }
        return file;
    }

    public void delFile(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File subFile : files) {
                subFile.delete();
            }
        }
    }
}
