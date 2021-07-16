package com.example.demo.expectiontest;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/7/13 9:04
 */
public class Main {

    public static void main(String[] args) {
        try{
            ExpectionOne.createOne();
            ExpectionTwo.createOne();
        }catch (Exception e){
            System.out.println("asdasdasdasdasd");
        }
    }
}
