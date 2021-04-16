package com.example.demo.study.fanxing;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import org.omg.CORBA.TRANSACTION_MODE;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/4/13 20:02
 */
public class FanXing {

    public static <T> T setName(T t) {
        Class<? extends Object> aClass = t.getClass();
        try {
            if (t instanceof Map) {
                ((Map<String, Object>) t).put("name", "加菲猫");
            } else {
                Field field = aClass.getDeclaredField("name");
                field.setAccessible(true);
                field.set(t, "波斯猫");
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }
}
