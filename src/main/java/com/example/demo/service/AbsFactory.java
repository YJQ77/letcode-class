package com.example.demo.service;

import com.example.demo.util.SpringContextUtil;
import org.springframework.core.io.ClassPathResource;

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
            FactoryConfig factoryConfig = (FactoryConfig) SpringContextUtil.getBean("factoryConfig");
            String account_service = factoryConfig.getAccount_service();
            obj = Class.forName(account_service).newInstance();
        } catch (Exception e) {
        } finally {
            return obj;
        }

    }
}
