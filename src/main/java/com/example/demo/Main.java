package com.example.demo;

import com.example.demo.util.reconciliation.BillDto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import sun.plugin.javascript.navig.Array;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/7/2 15:56
 */
public class Main {
    public static final String RECONCILIATION_SUCCESS_COUNT ="rec:count:%s:%s:%s";
    public static void main(String[] args) {
//        String format = String.format(RECONCILIATION_SUCCESS_COUNT, "330100", "2021-06-10", 1);
//        System.out.println(format);

//        List<String> list = new ArrayList<>();
//        for(int i = 0;i<451272;i++){
//            list.add("a"+"-"+i);
//        }
//        int downLatchCount = 10;
//        int size = list.size() ;
//        int number = size / downLatchCount;  //然后是商
//        List<String> list1;
//        for (int i = 0; i < downLatchCount; i++) {
//            if (i == downLatchCount - 1) {
//                list1 = list.subList(i * number, size);
//            } else {
//                list1 = list.subList(i * number, i * number + number);
//            }
//            System.out.println(list1.get(list1.size()-1));
//            System.out.println(list1.size());
//            System.out.println("=======================================");
//        }

        int i1 = Integer.parseInt("-3");
        System.out.println(i1+1);

        String s ="aaa||||1||33060120||1115127513||dphlfn||2020-07-07||330100||||";
        String[] split = s.split("\\|\\|");
        List<String> list = new ArrayList<>(Arrays.asList(split));
        System.out.println(list.size());
        if (list.size()!=10){
            for (int i = list.size();i<10;i++){
                list.add("");
            }
        }
        for (int i = 0;i<=9 ;i++){
            System.out.println(list.get(i).trim());
        }
    }
}
