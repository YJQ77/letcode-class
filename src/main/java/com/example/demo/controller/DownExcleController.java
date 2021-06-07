package com.example.demo.controller;

import com.example.demo.eip.DataModel;
import com.example.demo.service.DataModelService;
import com.example.demo.util.ExcleUtil;
import io.swagger.annotations.ApiOperation;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/down")
public class DownExcleController {

   @Autowired
   private DataModelService dataModelService;

    @ApiOperation(value = "自己生成下载excle文件下载")
    @GetMapping(value = "/datamodel.do")
    public ResponseEntity<Resource> downfromexcle() throws IOException {
        String[] title = {"总计","公立医院","私立医院","行政单位"};

        List<DataModel> list = dataModelService.getList();

        SXSSFWorkbook wb = ExcleUtil.getSXSSFWorkbook2("test", title, list, null);

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
}
