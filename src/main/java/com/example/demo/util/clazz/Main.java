package com.example.demo.util.clazz;

import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/6/4 14:24
 */
public class Main {

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("330100", 10);
        map.put("330102", 10);
        map.put("330103", 10);
        map.put("330201", 123);
        map.put("330202", 123);

        Map<String, Object> allmap = new HashMap<>();
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
        for (Entry entry: allmap.entrySet()) {
            System.out.println(entry);
        }

    }

}
