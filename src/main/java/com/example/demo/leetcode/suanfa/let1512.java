package com.example.demo.leetcode.suanfa;

/**
 * 描述：好数对的数目
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:05
 */
public class let1512 {
    class Solution {
        public int numIdenticalPairs(int[] nums) {
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j])
                        count++;
                }
            }
            return count;
        }
    }

}
