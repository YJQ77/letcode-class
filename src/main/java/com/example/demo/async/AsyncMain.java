package com.example.demo.async;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/7/2 15:11
 */
@Component
public class AsyncMain {
    @Autowired
    private AsyncFunction asyncFunction;

    public List<String> TestA(){
        System.out.println("主方法开始");
        List<String> list = new ArrayList<>();
        list.add("a");list.add("b");list.add("c");
        list.add("d");list.add("e");list.add("f");
        asyncFunction.TestAsync(list);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主方法结束");
        return list;
    }
}
