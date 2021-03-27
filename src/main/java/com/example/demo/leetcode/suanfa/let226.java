package com.example.demo.leetcode.suanfa;

/**
 * 描述：翻转二叉树
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:05
 */
public class let226 {

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
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;
            TreeNode amp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(amp);
            return root;
        }
    }
}
