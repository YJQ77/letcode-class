package com.example.demo.leetcode.suanfa;

/**
 * 描述：二叉树的坡度
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:05
 */
public class let563 {

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
        int res = 0;

        public int findTilt(TreeNode root) {
            dfs(root);
            return res;
        }

        public int dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int l = dfs(node.left);
            int r = dfs(node.right);
            res += Math.abs(l - r);
            return node.val + l + r;
        }
    }
}
