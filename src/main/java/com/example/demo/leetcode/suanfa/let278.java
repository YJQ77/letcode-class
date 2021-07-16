package com.example.demo.leetcode.suanfa;

/**
 * 描述：278. 第一个错误的版本
 *
 * @author yinjiaqi
 * @date 2021/7/15 13:50
 */
public class let278 {
    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 0;
            int right = n;
            int i=0;
            while (left<=n){
                i = left + (right - left) / 2;
                if (isBadVersion(i)){
                    right = i;
                }else{
                    left = i+1;
                }
            }
            return i;
        }
    }
    public class VersionControl{
        boolean isBadVersion(int version){
          return true;
        }
    }
}
