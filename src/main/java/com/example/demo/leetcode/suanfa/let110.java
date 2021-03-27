package com.example.demo.leetcode.suanfa;

/**
 * 描述：平衡二叉树
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:05
 */
public class let110 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            return isBalanced2(root) >= 1 ? true : false;
        }

        public int isBalanced2(TreeNode root) {
            if (root == null) return 0;
            int lh = isBalanced2(root.left);
            int rh = isBalanced2(root.right);
            if (lh != -1 && rh != -1 && Math.abs(lh - rh) <= 1) {
                return Math.max(lh, rh) + 1;
            } else {
                return -1;
            }
        }
    }
}
