package com.example.demo.leetcode.suanfa;

/**
 * 描述：二分查找
 *
 * @author yinjiaqi
 * @date 2021/3/30 9:54
 */
public class let704 {
    public static void main(String[] args) {
        int[] nums = {1,5};
        int search = Solution.search(nums, 5);
        System.out.println(search);
    }

    static class Solution {
        public static int search(int[] nums, int target) {
            int length = nums.length;
            if (target<nums[0] || target>nums[length-1]) return -1;
            int left = 0;
            int right  = length -1;
            while (left<=right){
                int mid = left + (right-left)/2;
                if (target == nums[mid]){
                    return mid;
                }
                else if(target<nums[mid]){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            return -1;
        }

    }
}
