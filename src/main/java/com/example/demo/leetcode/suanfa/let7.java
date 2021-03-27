package com.example.demo.leetcode.suanfa;

/**
 * 描述：整数反转
 *
 * @author yinjiaqi
 * @date 2021/3/27 13:58
 */
public class let7 {
    class Solution {
        public int reverse(int x) {
            long result=0;
            while(x!=0){
                result = result*10+(x%10);
                x= x/10;
            }
            return (int)result==result? (int)result:0;
        }
    }
}
