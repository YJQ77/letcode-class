package com.example.demo.leetcode.suanfa;

/**
 * 描述：左叶子之和
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:05
 */
public class let404 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) return 0;
            int res = 0;
            if (root.left != null && root.left.left == null && root.left.right == null) {
                res = res + root.left.val;
            }
            return res + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);

        }
    }
}
