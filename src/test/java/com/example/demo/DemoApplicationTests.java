package com.example.demo;

import com.example.demo.service.AbsFactory;
import com.example.demo.service.FactoryConfig;
import com.example.demo.service.impl.Dynamic;
import com.example.demo.util.SpringContextUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void TestProperties() {
        FactoryConfig factoryConfig = (FactoryConfig) SpringContextUtil.getBean("factoryConfig");
        System.out.println(factoryConfig);
        Dynamic accountService = (Dynamic) AbsFactory.createByType("");
        System.out.println(accountService);
    }

}
