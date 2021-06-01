package com.example.demo.study;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/5/14 16:01
 */
public class ProxyTets implements InvocationHandler {
    private Object proxyObject;

    public ProxyTets(Object proxy) {
        this.proxyObject = proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jiancha");
        Object invoke = method.invoke(proxyObject, args);
        System.out.println("sucess");
        return invoke;
    }
}
