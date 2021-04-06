package com.example.demo.leetcode.suanfa;

/**
 * 描述：删除有序数组中的重复项
 *
 * @author yinjiaqi
 * @date 2021/4/2 14:14
 */
public class let26 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) return 0;
            int length = nums.length;
            int i = 0;
            for (int j = 1; j < length; j++) {
                if (nums[i] != nums[j]) {
                   i++;
                   nums[i] = nums[j];
                }
            }
            return i+1;
        }
    }
}
