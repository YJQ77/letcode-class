package com.example.demo.leetcode.suanfa;

/**
 * 描述：剑指 Offer 55 - I. 二叉树的深度
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:42
 */
public class let剑指Offer55 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
