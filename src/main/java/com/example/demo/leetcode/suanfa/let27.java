package com.example.demo.leetcode.suanfa;

/**
 * 描述：移除元素
 *
 * @author yinjiaqi
 * @date 2021/3/31 14:46
 */
public class let27 {
    class Solution {
        public int removeElement(int[] nums, int val) {
                int i= 0 ;
                for (int j=0;j<nums.length;j++){
                    if(nums[j]!=val){
                        nums[i] = nums[j];
                        i++;
                    }
                }
                return i;
        }
    }
}
