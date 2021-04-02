package com.example.demo;

import com.example.demo.service.AbsFactory;
import com.example.demo.config.FactoryConfig;
import com.example.demo.service.impl.Dynamic;
import com.example.demo.util.SpringContextUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void TestProperties() {
        FactoryConfig factoryConfig = (FactoryConfig) SpringContextUtil.getBean("factoryConfig");
        System.out.println(factoryConfig);
        Dynamic accountService = (Dynamic) AbsFactory.createByType("test.account_service");
        System.out.println(accountService);
    }

}
