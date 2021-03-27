package com.example.demo.leetcode.suanfa;

/**
 * 描述：二叉搜索树中的搜索
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:05
 */
public class let700 {

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
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null || val == root.val) return root;
            return val >= root.val ? searchBST(root.right, val) : searchBST(root.left, val);
        }
    }
}
