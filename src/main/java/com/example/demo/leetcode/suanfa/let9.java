package com.example.demo.leetcode.suanfa;

/**
 * 描述：回文数
 *
 * @author yinjiaqi
 * @date 2021/3/27 13:59
 */
public class let9 {
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            if (x == 0) {
                return true;
            }
            int tem = 0, y = 0;
            int pos = x;
            while (pos != 0) {
                tem = pos % 10;
                y = y * 10 + tem;
                pos = pos / 10;
            }
            return x == y;

        }
    }
}
