package com.example.demo.leetcode.suanfa;

/**
 * 描述：对称二叉树
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:04
 */
public class let101 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isSame(root.left, root.right);
        }

        public boolean isSame(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null) {
                return true;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
            return isSame(node1.left, node2.right) & isSame(node1.right, node2.left);
        }
    }
}
