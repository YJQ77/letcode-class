package com.example.demo.controller;

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
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
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

    @ApiOperation(value = "根据url下载")
    @GetMapping(value = "/get.do")
    public MxtjDto get() throws IOException {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("qydm", "330100");map.put("glsl", 19);map.put("kpglsl", 12);
        Map<String, Object> allmap = new LinkedHashMap<String,Object>();
        Set<String> keys = map.keySet();
        String s = null;
        Integer count = 0;
        for (String key : keys) {
            s = key.substring(0, 4) + "00";
            if (allmap.containsKey(s)) {
                count = ((Integer) allmap.get(s)) + ((Integer) map.get(key));
            } else {
                count = ((Integer) map.get(key));
            }
            allmap.put(s, count);
        }
        map.putAll(allmap);
        MxtjDto mxtjDto = (MxtjDto) ReflectUtil.getObject(new MxtjDto(), map);
        return mxtjDto;
    }
}
