package com.example.demo.leetcode.suanfa;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述：剑指 Offer 03. 数组中重复的数字
 *
 * @author yinjiaqi
 * @date 2021/4/26 14:25
 */
public class let剑指Offer3 {
    public int findRepeatNumber(int[] nums) {
        int[] temp = new int[nums.length];
        for (int i = 0;i<nums.length;i++){
            temp[nums[i]] = temp[nums[i]]+1;
        }
        int result = -1;
        for (int i =0;i<temp.length;i++){
            if (temp[i]>1){
                result = i;
                break;
            }
        }
        return result;
    }

    public int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (set.add(nums[i])){
            i++;
        }
        return nums[i];
    }
}
