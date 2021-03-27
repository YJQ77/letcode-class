package com.example.demo.leetcode.suanfa;

/**
 * 描述：最富有客户的资产总量
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:37
 */
public class let1672 {

    class Solution {
        public int maximumWealth(int[][] accounts) {
            int max = 0;
            for (int i = 0; i < accounts.length; i++) {
                int count = 0;
                for (int j = 0; j < accounts[i].length; j++) {
                    count = count + accounts[i][j];
                }
                if (count >= max) {
                    max = count;
                }
            }
            return max;
        }
    }
}
