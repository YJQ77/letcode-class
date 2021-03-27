package com.example.demo.leetcode.suanfa;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：二叉树的前序遍历
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:05
 */
public class let144 {

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
        List<Integer> list = new ArrayList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) return list;
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            return list;
        }
    }
}
