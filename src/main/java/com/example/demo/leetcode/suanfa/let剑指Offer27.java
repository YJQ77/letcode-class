package com.example.demo.leetcode.suanfa;

/**
 * 描述：二叉树的镜像
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:40
 */
public class let剑指Offer27 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) return null;
            TreeNode amp = root.left;
            root.left = mirrorTree(root.right);
            root.right = mirrorTree(amp);
            return root;
        }
    }
}
