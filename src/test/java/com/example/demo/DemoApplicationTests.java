package com.example.demo;

import com.example.demo.service.AbsFactory;
import com.example.demo.config.FactoryConfig;
import com.example.demo.service.impl.Dynamic;
import com.example.demo.util.FtpUtil;
import com.example.demo.util.SpringContextUtil;
import com.example.demo.util.reconciliation.BillDto;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private FtpUtil ftpUtil;

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

    @Test
    void TestFtp() {
        List<String> areaCodes = Arrays.asList("330100","330200");
        for (String areaCode : areaCodes) {
            List<BillDto> list = ftpUtil.getFileByPath(areaCode+ "/20210624");
            list.forEach(System.out::println);

            ftpUtil.createTxtFile(Arrays.asList(areaCode+"\n","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n","bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb\n"));
            ftpUtil.uploadBuChuan(areaCode+ "/20210624/");
            ftpUtil.delFile("D:\\temp");
            System.out.println("===================================================");
        }
    }

}
