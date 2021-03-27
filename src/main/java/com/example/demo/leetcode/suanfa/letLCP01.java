package com.example.demo.leetcode.suanfa;

/**
 * 描述：LCP 01. 猜数字
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:39
 */
public class letLCP01 {
    class Solution {
        public int game(int[] guess, int[] answer) {
            int count = 0;
            for(int i =0;i<3;i++){
                if(guess[i] == answer[i]) {
                    count++;
                }
            }
            return count;
        }
    }
}
