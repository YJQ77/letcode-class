package com.example.demo.controller;

import com.example.demo.service.DataModelService;
import com.example.demo.util.clazz.MxtjDto;
import com.example.demo.util.clazz.ReflectUtil;
import io.swagger.annotations.ApiOperation;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/6/4 14:29
 */

@RestController
@RequestMapping(value = "/reflect")
public class ReflectController {

    @Autowired
    private DataModelService dataModelService;

    @ApiOperation(value = "根据url下载")
    @GetMapping(value = "/get.do")
    public List<MxtjDto> get() throws IOException {
        List<Map<String, Object>> maps = dataModelService.getMap2();
        List<MxtjDto> list = new ArrayList<>();
        for (Map<String, Object> map : maps){
            MxtjDto mxtjDto = (MxtjDto) ReflectUtil.getObject(new MxtjDto(), map);
            list.add(mxtjDto);
        }
        return list;
    }
}
