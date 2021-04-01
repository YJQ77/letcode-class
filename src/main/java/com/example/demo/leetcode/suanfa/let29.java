package com.example.demo.leetcode.suanfa;

/**
 * 描述：两数相除
 *
 * @author yinjiaqi
 * @date 2021/3/31 14:56
 */
public class let29 {
    public static void main(String[] args) {
        int divide = Solution.divide( -2147483648, -1);
        System.out.println(divide);
    }
     static class Solution {
        public static int divide(int dividend, int divisor) {
            long dividend1 = dividend;
            long divisor1 = divisor;
            long i = Math.abs(dividend1);
            long j = Math.abs(divisor1);
            if(i<j) return 0;
            long result = 0;
            while (i>=j){
                i = i-j;
                result++;
            }
            if (result>2147483647)
            {
                return 2147483647;
            }
            if ((dividend1<0 && divisor1>0) || (dividend1>0 && divisor1<0)){
                result = result - (result+result);
            }
            return (int)result;
        }
    }
}
