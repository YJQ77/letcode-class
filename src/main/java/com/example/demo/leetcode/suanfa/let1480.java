package com.example.demo.leetcode.suanfa;

/**
 * 描述：一维数组的动态和
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:05
 */
public class let1480 {
    class Solution {
        public int[] runningSum(int[] nums) {
            int[] result = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j <= i; j++) {
                    result[i] = result[i]+nums[j];
                }
            }
            return result;
        }
    }
}
