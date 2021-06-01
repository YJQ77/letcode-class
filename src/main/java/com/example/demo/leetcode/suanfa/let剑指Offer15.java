package com.example.demo.leetcode.suanfa;

/**
 * 描述：剑指 Offer 15. 二进制中1的个数
 *
 * @author yinjiaqi
 * @date 2021/3/30 19:21
 */
public class let剑指Offer15 {

    public static void main(String[] args) {
        hammingWeight(00000000000000000000000000001011);
    }

        public static int hammingWeight(int n) {
            int result = 0;
            while (n!=0){
                result++;
              n = n&(n-1);
            }
            return result;
        }

}
