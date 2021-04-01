package com.example.demo.leetcode.suanfa;

/**
 * 描述：实现 strStr()
 *
 * @author yinjiaqi
 * @date 2021/3/31 14:49
 */
public class let28 {
    public static void main(String[] args) {

    }
    class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.equalsIgnoreCase("")) return 0;
            int i = haystack.indexOf(needle);
            return i;
        }
    }
}
