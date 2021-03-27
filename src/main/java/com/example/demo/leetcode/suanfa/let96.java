package com.example.demo.leetcode.suanfa;

/**
 * 描述：不同的二叉搜索树
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:04
 */
public class let96 {
    class Solution {
        public int numTrees(int n) {
            int[] G = new int[n+1];
            G[0]=1;
            G[1] = 1;
            for(int i=2;i<=n;i++){
                for(int j = 1;j<=i;j++){
                    G[i] += G[j-1]*G[i-j];
                }
            }
            return G[n];
        }
    }
}
