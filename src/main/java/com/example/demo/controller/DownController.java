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

@RestController
@RequestMapping(value = "/down")
public class DownController {

    @ApiOperation(value = "根据url下载")
    @GetMapping(value = "/downfromurl.do")
    public ResponseEntity<Resource> downfromurl() throws IOException {
        URL url = new URL("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.deskcity.org%2Fpic_360%2F69%2F7f%2Fc4%2F697fc4def1018c58aa843fa11f8d0120.jpg&refer=http%3A%2F%2Fup.deskcity.org&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1619263586&t=e8b57cfd79acd550829e6d9d6d779517");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // 设置超时间为3秒
        conn.setConnectTimeout(3000);
        // 防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        // 得到输入流
        InputStream inputStream = conn.getInputStream();
        // 获取自己数组
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        byte[] bytes = bos.toByteArray();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentDispositionFormData("attachment", URLEncoder.encode("test.png", "UTF-8"));
        httpHeaders.setContentType(MediaType.IMAGE_PNG);
        Resource resource = new InputStreamResource(
                new ByteArrayInputStream(bytes));
        return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.IMAGE_PNG)
                .body(resource);
    }

    @ApiOperation(value = "根据file文件下载")
    @GetMapping(value = "/downfromfile.do")
    public ResponseEntity<Resource> downfromfile() throws IOException {
        File file = new File("C:\\Users\\admin\\Desktop\\test.png");


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentDispositionFormData("attachment", URLEncoder.encode("test.png", "UTF-8"));
        httpHeaders.setContentType(MediaType.IMAGE_PNG);

        FileInputStream fileInputStream = new FileInputStream(file);

        byte[] fileByte = new byte[(int) file.length()];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bytes, 0, bytes.length)) != -1) {
            byteArrayOutputStream.write(bytes, 0, len);
        }
        byteArrayOutputStream.close();
        fileByte = byteArrayOutputStream.toByteArray();

        Resource resource = new InputStreamResource(
                new ByteArrayInputStream(fileByte));
        return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.IMAGE_PNG)
                .body(resource);
    }



    @ApiOperation(value = "自己生成下载excle文件下载")
    @GetMapping(value = "/downfromexcle.do")
    public ResponseEntity<Resource> downfromexcle() throws IOException {
        String[] title = {"name","age","sex"};
        List<Map<String,Object>> maps = new ArrayList<>();
        Map<String,Object> map = null;
        for (int i = 0;i<3;i++){
            map = new HashMap<>();
            map.put("0",i+"a");
            map.put("1",i+"b");
            map.put("2",i+"c");
            maps.add(map);
        }

        XSSFWorkbook wb = ExcleUtil.getXSSFWorkbook("test", title, maps, null);
         wb = ExcleUtil.getXSSFWorkbook("test2", title, maps, wb);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentDispositionFormData("attachment", URLEncoder.encode("test.xlsx", "UTF-8"));
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        byte[] fileByte = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        wb.write(byteArrayOutputStream);

        byteArrayOutputStream.close();
        fileByte = byteArrayOutputStream.toByteArray();

        Resource resource = new InputStreamResource(
                new ByteArrayInputStream(fileByte));
        return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.IMAGE_PNG)
                .body(resource);
    }

    @ApiOperation(value = "根据模板excle文件填充下载")
    @GetMapping(value = "/downfromexcletemplate.do")
    public ResponseEntity<Resource> downfromexcletemplate() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ClassPathResource classPathResource = new ClassPathResource("excleTemplate/test.xlsx");
        InputStream in =classPathResource.getInputStream();
        try{
            XSSFWorkbook wb = new XSSFWorkbook(in);
            //SXSSFWorkbook workbook = new SXSSFWorkbook(wb);
            XSSFSheet sheet1 = wb.getSheet("test");
            XSSFRow row = sheet1.createRow(1);
            row.createCell(0).setCellValue("yinjiaqi");
            row.createCell(1).setCellValue(24);
            row.createCell(2).setCellValue("hangzhou");

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentDispositionFormData("attachment", URLEncoder.encode("test.xlsx", "UTF-8"));
            httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);

            byte[] fileByte = new byte[1024];
            wb.write(byteArrayOutputStream);
            fileByte = byteArrayOutputStream.toByteArray();

            Resource resource = new InputStreamResource(
                    new ByteArrayInputStream(fileByte));
            return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.IMAGE_PNG)
                    .body(resource);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }finally {
            byteArrayOutputStream.close();
            in.close();
        }
    }
}
