package com.example.demo.leetcode.suanfa;

/**
 * 描述：罗马数字转整数
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:02
 */
public class let13 {
    class Solution {
        public int romanToInt(String s) {
            int[] vlaues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] key = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            int i = 0;
            int result = 0;
            while (s.length() > 0) {
                if (s.startsWith(key[i])) {
                    result = result + vlaues[i];
                    s = s.replaceFirst(key[i], "").trim();
                }
                if (!s.startsWith(key[i])) {
                    i++;
                }
            }
            return result;
        }
    }
}
