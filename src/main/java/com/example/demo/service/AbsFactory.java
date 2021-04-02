package com.example.demo.service;

import sun.plugin.javascript.ReflectUtil;

import java.io.InputStream;
import java.util.Properties;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/3/30 14:30
 */
public class AbsFactory {
    public static Object obj;

    public static Object createByType(String createName) {
        try {
           // FactoryConfig factoryConfig = (FactoryConfig) SpringContextUtil.getBean("factoryConfig");
           // String account_service = factoryConfig.getAccount_service();
            Properties properties = new Properties();
            ClassLoader classLoader = ReflectUtil.class.getClassLoader();
            InputStream stream = classLoader.getResourceAsStream("factory.properties");
            properties.load(stream);
            String property = properties.getProperty(createName);
            obj = Class.forName(property).newInstance();
        } catch (Exception e) {
        } finally {
            return obj;
        }

    }
}
