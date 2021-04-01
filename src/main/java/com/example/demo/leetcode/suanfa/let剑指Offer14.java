package com.example.demo.leetcode.suanfa;

/**
 * 描述：剑指 Offer 14- I. 剪绳子
 *
 * @author yinjiaqi
 * @date 2021/3/30 19:21
 */
public class let剑指Offer14 {
    class Solution {
        public int cuttingRope(int n) {
            int result = 1;
            if (n == 2) return 1;
            if (n == 3) return 2;
            while (n > 4) {
                result = result * 3;
                n = n - 3;
            }
            if (n == 4) result = result * 4;
            else if (n == 3) result = result * 3;
            else if (n == 2) result = result * 2;
            return result;
        }
    }
}
