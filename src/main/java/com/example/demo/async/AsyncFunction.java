package com.example.demo.async;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Async;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/7/2 15:08
 */
@Component
public class AsyncFunction {

    @Async(value = "asyncTaskExecutor")
    public void TestAsync(List<String> list) {
        System.out.println("异步执行打印");
        list.forEach(System.out::print);
        System.out.println();
        System.out.println("异步等待结束...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("异步结束");
    }

}
