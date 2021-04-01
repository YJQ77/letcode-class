package com.example.demo.leetcode.suanfa;

/**
 * 描述：搜索插入位置
 * 划分 [left, mid] 与 [mid + 1, right] ，mid 被分到左边，对应 int mid = left + (right - left) / 2;；
 * 划分 [left, mid - 1] 与 [mid, right] ，mid 被分到右边，对应 int mid = left + (right - left + 1) / 2;。
 *
 * @author yinjiaqi
 * @date 2021/3/29 19:59
 */
public class let35 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int i = Solution.searchInsert(nums, 5);
        System.out.println(i);
    }

    static class Solution {
        public static int searchInsert(int[] nums, int target) {
            int length = nums.length;
            if (length == 0) {
                return 0;
            }
            if (nums[length - 1] < target) {
                return length;
            }
            int left = 0;
            int right = length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

    }
}
