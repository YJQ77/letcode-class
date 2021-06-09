package com.example.demo.util.clazz;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/6/7 13:10
 */
public class DtoToMap {

    public static Map<String,Object> dtoToMap(Object obj, List<String> fileName) {
        Map<String,Object> map = new LinkedHashMap<>();
        if (null != obj) {
            Class cla = obj.getClass();
            Field[] fields = cla.getDeclaredFields();
            //for (Field field : fields) {
            for (String name : fileName) {
               // String name = field.getName();
              //  if (fileName.contains(name)){
                    try {
                        Method method = cla.getMethod("get" + initCap(name), null);
                        map.put(name, method.invoke(obj, null));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
               // }
            }
        }
        return map;

    }

    public static Map<String,Object> dtoToMap2(Object obj, List<String> fileName) {
        Map<String,Object> map = new TreeMap<>();
        if (null != obj) {
            Class cla = obj.getClass();
            int i=1000;
            for (String name : fileName) {
                try {
                    Method method = cla.getMethod("get" + initCap(name), null);
                    map.put(i+"excle", method.invoke(obj, null));
                    i++;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return map;

    }

    /**
     * s
     *
     * @param attr
     * @return 大写形式的属性名称
     * @description 替换DTO属性名称首字母为大写 如：name-->Name
     */

    private static String initCap(String attr) {
        return attr.substring(0, 1).toUpperCase() + attr.substring(1);
    }
}
