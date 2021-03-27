package com.example.demo.leetcode.suanfa;

/**
 * 描述：整数转罗马数字
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:01
 */
public class let12 {
    class Solution {
        public String intToRoman(int num) {
            int[] vlaues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] key = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            int i = 0;
            StringBuffer sb = new StringBuffer();
            while (num > 0) {
                if (num >= vlaues[i]) {
                    num = num - vlaues[i];
                    sb.append(key[i]);
                }
                if (num < vlaues[i]) {
                    i++;
                }
            }
            return sb.toString();
        }
    }

}
