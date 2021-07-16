package com.example.demo.expectiontest;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/7/13 9:02
 */
public class ExpectionTwo {
    public static void createOne(){
        System.out.println("异常2");
        throw new RuntimeException("异常2");
    }

}
