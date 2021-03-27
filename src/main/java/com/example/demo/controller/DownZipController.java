package com.example.demo.controller;

import com.example.demo.util.ExcleUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/3/26 8:47
 */
@RestController
@RequestMapping(value = "/downzip")
public class DownZipController {
    @ApiOperation(value = "根据file文件打包zip下载")
    @GetMapping(value = "/downfromfiletozip.do")
    public ResponseEntity<Resource> downfromfiletozip() throws IOException {
        File file = new File("C:\\Users\\admin\\Desktop\\test.png");
        File file2 = new File("C:\\Users\\admin\\Desktop\\test2.png");

        List<File> files = new ArrayList<>();
        files.add(file);
        files.add(file2);

        String nowTimeString = System.currentTimeMillis() + "";
        String downloadFilename = nowTimeString + ".zip";//文件的名称

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentDispositionFormData("attachment", URLEncoder.encode(downloadFilename, "UTF-8"));
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        int length = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ZipOutputStream zos = new ZipOutputStream(byteArrayOutputStream);
        FileInputStream fileInputStream = null;
        for (int i = 0; i <= 1; i++) {
            File file1 = files.get(i);
            length = length + (int) file1.length();
            fileInputStream = new FileInputStream(files.get(i));
            byte[] bytes = new byte[1024];
            zos.putNextEntry(new ZipEntry(file1.getName()));
            int len;
            while ((len = fileInputStream.read(bytes, 0, 1024)) != -1) {
                zos.write(bytes, 0, len);
            }
        }
        byte[] fileByte = new byte[length];
        fileByte = byteArrayOutputStream.toByteArray();
        Resource resource = new InputStreamResource(
                new ByteArrayInputStream(fileByte));

        byteArrayOutputStream.close();
        zos.closeEntry();
        zos.close();
        return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.IMAGE_PNG)
                .body(resource);
    }

    @ApiOperation(value = "根据url打包成zip下载")
    @GetMapping(value = "/downfromurltozip.do")
    public ResponseEntity<Resource> downfromurltozip() throws IOException {
        String[] urls = {"https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.deskcity.org%2Fpic_360%2F69%2F7f%2Fc4%2F697fc4def1018c58aa843fa11f8d0120.jpg&refer=http%3A%2F%2Fup.deskcity.org&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1619263586&t=e8b57cfd79acd550829e6d9d6d779517",
                "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.deskcity.org%2Fpic_360%2F69%2F7f%2Fc4%2F697fc4def1018c58aa843fa11f8d0120.jpg&refer=http%3A%2F%2Fup.deskcity.org&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1619263586&t=e8b57cfd79acd550829e6d9d6d779517"};
        URL url = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ZipOutputStream zos = new ZipOutputStream(bos);
        for (int i = 0; i < 2; i++) {
            url = new URL(urls[i]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 设置超时间为3秒
            conn.setConnectTimeout(3000);
            // 防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            // 得到输入流
            InputStream inputStream = conn.getInputStream();
            BufferedInputStream buff = new BufferedInputStream(inputStream);
            // 获取自己数组
            byte[] buffer = new byte[1024];
            char[] chars = new char[1024];
            zos.putNextEntry(new ZipEntry(i + ".png"));
            int len = 0;
//            while ((len = inputStream.read(buffer)) != -1) {
//                zos.write(buffer, 0, len);
//            }
            while ((len = buff.read(buffer)) != -1) {
                zos.write(buffer, 0, len);
            }
        }
        bos.close();
        zos.close();
        byte[] bytes = bos.toByteArray();


        String nowTimeString = System.currentTimeMillis() + "";
        String downloadFilename = nowTimeString + ".zip";//文件的名称
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentDispositionFormData("attachment", URLEncoder.encode(downloadFilename, "UTF-8"));
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        Resource resource = new InputStreamResource(
                new ByteArrayInputStream(bytes));
        return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.IMAGE_PNG)
                .body(resource);
    }

    @ApiOperation(value = "自己生成excle打包zip文件下载")
    @GetMapping(value = "/downfromexcle.do")
    public ResponseEntity<Resource> downfromexcle() throws IOException {
        String[] title = {"name", "age", "sex"};
        List<Map<String, Object>> maps = new ArrayList<>();
        Map<String, Object> map = null;
        for (int i = 0; i < 3; i++) {
            map = new HashMap<>();
            map.put("0", i + "a");
            map.put("1", i + "b");
            map.put("2", i + "c");
            maps.add(map);
        }

        XSSFWorkbook wb = ExcleUtil.getXSSFWorkbook("test", title, maps, null);
        XSSFWorkbook wb2 = ExcleUtil.getXSSFWorkbook("test2", title, maps, wb);

        List<XSSFWorkbook> list = new ArrayList<>();
        list.add(wb);
        list.add(wb2);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentDispositionFormData("attachment", URLEncoder.encode("test.zip", "UTF-8"));
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        byte[] fileByte = new byte[1024];
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ZipOutputStream zos = new ZipOutputStream(bos);
        ByteArrayOutputStream bos2 = null;
        for (int i = 0; i < list.size(); i++) {
          bos2= new ByteArrayOutputStream();
          zos.putNextEntry(new ZipEntry(i+".xlsx"));
          list.get(i).write(bos2);
          bos2.writeTo(zos);
        }
        zos.closeEntry();
        bos2.close();
        bos.close();
        zos.close();
        fileByte = bos.toByteArray();

        Resource resource = new InputStreamResource(
                new ByteArrayInputStream(fileByte));
        return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.IMAGE_PNG)
                .body(resource);
    }

    @ApiOperation(value = "根据模板excle文件填充下载")
    @GetMapping(value = "/downfromexcletemplatetozip.do")
    public ResponseEntity<Resource> downfromexcletemplatetozip() throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ClassPathResource classPathResource = new ClassPathResource("excleTemplate/test.xlsx");
        InputStream in = classPathResource.getInputStream();
        ZipOutputStream zip = new ZipOutputStream(bos);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            XSSFWorkbook wb = new XSSFWorkbook(in);
            XSSFSheet sheet = wb.getSheet("test");
            XSSFRow row = sheet.createRow(1);
            row.createCell(0).setCellValue("yinjiaqi");
            row.createCell(1).setCellValue(24);
            row.createCell(2).setCellValue("hangzhou");
            zip.putNextEntry(new ZipEntry("test.xlsx"));
            wb.write(out);
            out.writeTo(zip);
        }catch (Exception e){

        }finally {
            bos.close();
            in.close();
            zip.close();
            out.close();
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentDispositionFormData("attachment", URLEncoder.encode("test.zip", "UTF-8"));
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        byte[] fileByte = new byte[1024];
        fileByte = bos.toByteArray();

        Resource resource = new InputStreamResource(
                new ByteArrayInputStream(fileByte));
        return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.IMAGE_PNG)
                .body(resource);
    }
}
