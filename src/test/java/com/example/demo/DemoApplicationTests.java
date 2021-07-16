package com.example.demo;

import com.example.demo.async.AsyncMain;
import com.example.demo.service.AbsFactory;
import com.example.demo.config.FactoryConfig;
import com.example.demo.service.impl.Dynamic;
import com.example.demo.util.FtpUtil;
import com.example.demo.util.SpringContextUtil;
import com.example.demo.util.reconciliation.BillDto;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.apache.commons.collections.ArrayStack;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private FtpUtil ftpUtil;
    @Autowired
    private AsyncMain asyncMain;

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
        List<String> areaCodes = Arrays.asList("杭州市", "宁波市");
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String dateYmd = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        for (String areaCode : areaCodes) {
            List<BillDto> result = new ArrayList<>();
            List<BillDto> list = ftpUtil.getFileByPath(areaCode + "/" + date + "/source");
            list.forEach(System.out::println);
//            for (BillDto billDto : list) {
//                //查询是否已在库中
//                int count = 0;
//                //已存在 尝试去更新票据
//                if (count>0) {
//                    result.add(billDto);
//                }
//                //不存在 记录票据信息
//                else {
//                    result.add(billDto);
//                }
//            }
//            //将对账失败的票据写入txt上传到ftp
//            if (!CollectionUtils.isEmpty(result)) {
//                //批量插入对账失败的票据信息
//                ftpUtil.createTxtFile(result);
//                ftpUtil.uploadBuChuan(areaCode, dateYmd);
//                ftpUtil.delFile("D:\\temp");
//            }
            //将对账结果插入结果统计表

            System.out.println("===================================================");
        }
    }

    @Test
    void TestAsync() {
        System.out.println("全流程开始");
        List<String> list = asyncMain.TestA();
        System.out.println("主方法打印");
        list.forEach(System.out::print);
        System.out.println();
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("全流程结束");
    }
}
