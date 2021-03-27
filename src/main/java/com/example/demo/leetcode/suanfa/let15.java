package com.example.demo.leetcode.suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 描述：三数之和
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:04
 */
public class let15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> lists = new ArrayList<>();
            if (nums.length < 3) return Collections.EMPTY_LIST;
            Arrays.sort(nums);
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                if (nums[0] > 0 || nums[len - 1] < 0) return Collections.EMPTY_LIST;
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int L = i + 1;
                int R = len - 1;
                while (L < R) {
                    int temp = nums[L] + nums[i] + nums[R];
                    if (temp == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[L]);
                        list.add(nums[R]);
                        lists.add(list);
                        while (L < R && nums[L + 1] == nums[L]) L++;
                        while (L < R && nums[R] == nums[R - 1]) R--;
                        L++;
                        R--;
                    } else if (temp < 0) {
                        L++;
                    } else if (temp > 0) {
                        R--;
                    }
                }
            }
            return lists;
        }
    }

}
