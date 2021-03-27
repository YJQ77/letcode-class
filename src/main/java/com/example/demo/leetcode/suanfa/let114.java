package com.example.demo.leetcode.suanfa;


import java.util.ArrayList;
import java.util.List;

/**
 * 描述：二叉树展开为链表
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:05
 */
public class let114 {


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
        List<TreeNode> list = new ArrayList<>();

        public void flatten(TreeNode root) {
            List<TreeNode> nodeList = getNodeList(root);
            for (int i = 0; i < list.size() - 1; i++) {
                nodeList.get(i).left = null;
                nodeList.get(i).right = nodeList.get(i + 1);
            }
        }

        public List<TreeNode> getNodeList(TreeNode root) {
            if (root == null) return list;
            list.add(root);
            getNodeList(root.left);
            getNodeList(root.right);
            return list;
        }

    }

}
