package com.example.demo.leetcode.suanfa;

/**
 * 描述： 盛最多水的容器
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:00
 */
public class let11 {
    class Solution {
        public int maxArea(int[] height) {
            int r = height.length-1;
            int l = 0;
            int result = 0;
            while((r-l)>0){
                int a = Math.min(height[l],height[r])*(r-l);
                result = Math.max(result,a);
                if(height[l]<height[r]) l++;
                else r--;
            }
            return result;
        }
    }
}
