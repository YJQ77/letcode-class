package com.example.demo.leetcode.suanfa;

/**
 * 描述：剑指 Offer 58 - II. 左旋转字符串
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:42
 */
public class let剑指Offer58 {
    class Solution {
        public String reverseLeftWords(String s, int n) {
            String substring = s.substring(n);
            String substring1 = s.substring(0, n);
            return substring + substring1;
        }
    }
}
