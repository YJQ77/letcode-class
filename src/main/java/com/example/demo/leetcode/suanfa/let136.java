package com.example.demo.leetcode.suanfa;

/**
 * 描述：136. 只出现一次的数字
 *
 * @author yinjiaqi
 * @date 2021/5/10 16:13
 */
public class let136 {

    public static void main(String[] args) {
        int[] nums= {4,1,2,1,2};
        int i = singleNumber(nums);

    }
    public static int singleNumber(int[] nums) {
        int result = 0;
        for(int num:nums ){
            result ^= num;
        }
        return result;
    }
}
