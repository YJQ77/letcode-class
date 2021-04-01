package com.example.demo.service.impl;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/3/30 14:27
 */
public class Dynamic {
    private static int age;
    private String name;
    static {
        age = 10;
        System.out.println("执行静态代码块"+age);
    }

    public Dynamic(String name) {
        this.name = name;
        System.out.println("执行构造函数"+name);
    }
}
