package com.example.demo.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/5/14 15:50
 */
public class Main {

    public static void main(String[] args) {
//       saveMoney s =new saveMoneyImple();
//       s.saveRmb(10);
//       ProxyTets proxyTets = new ProxyTets(s);
//       proxyTets.

//        List<String> list = new ArrayList<>();
//        list.add("aaa");list.add("bbb");list.add("ccc");list.add("ddd");list.add("eee");
//        List<User> users = new ArrayList<>();
//        users.add(new User("a","aa"));users.add(new User("b","bb"));users.add(new User("f","ff"));users.add(new User("e","ee"));
//
//        List<User> collect = users.stream().filter(e -> !list.contains(e.getA() + e.getB())).collect(Collectors.toList());
//        collect.forEach(System.out::println);


        HashMap<Object, CountDownLatch> hashMap = new HashMap<>();
        CountDownLatch countDownLatch1 = new CountDownLatch(1);
        CountDownLatch countDownLatch2 = new CountDownLatch(1);
        CountDownLatch countDownLatch3 = new CountDownLatch(1);
        hashMap.put("1",countDownLatch1);
        hashMap.put("2",countDownLatch2);
        hashMap.put("3",countDownLatch3);
        countDownLatch1.countDown();
        new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        hashMap.get("1").await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(1);
                    hashMap.put("1",new CountDownLatch(1));
                    hashMap.get("2").countDown();
                }

            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        hashMap.get("2").await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(2);
                    hashMap.put("2",new CountDownLatch(1));
                    hashMap.get("3").countDown();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        hashMap.get("3").await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(3);
                    hashMap.put("3",new CountDownLatch(1));
                    hashMap.get("1").countDown();
                }
            }
        }.start();
    }
}
