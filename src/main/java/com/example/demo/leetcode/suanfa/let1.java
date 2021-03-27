package com.example.demo.leetcode.suanfa;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：两数之和
 *
 * @author yinjiaqi
 * @date 2021/3/27 13:55
 */
public class let1 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    return new int[]{map.get(nums[i]), i};
                }
                map.put(target - nums[i], i);
            }
            return null;
        }
    }
}
