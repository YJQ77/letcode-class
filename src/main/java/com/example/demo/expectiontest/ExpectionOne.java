package com.example.demo.expectiontest;

import lombok.extern.slf4j.Slf4j;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/7/13 9:02
 */
@Slf4j
public class ExpectionOne {
    public static void createOne(){

        for (int i =0 ;i<10 ;i++){
            System.out.println("异常:"+i);
            if(i==5){
                try {
                    throw new Exception("发生异常了");
                } catch (Exception e) {
                   log.error(e.getMessage(),e);
                }
            }
        }
    }
}
