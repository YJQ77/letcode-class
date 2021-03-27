package com.example.demo.leetcode.suanfa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 描述：两棵二叉搜索树中的所有元素
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:05
 */
public class let1305 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            List<Integer> node1 = getNode1(root1);
            List<Integer> node11 = getNode2(root2);
            node1.addAll(node11);
            Collections.sort(node1);
            return node1;
        }

        public List<Integer> getNode1(TreeNode root1) {
            if (root1 == null) return list;
            getNode1(root1.left);
            list.add(root1.val);
            getNode1(root1.right);
            return list;
        }

        public List<Integer> getNode2(TreeNode root1) {
            if (root1 == null) return list2;
            getNode1(root1.left);
            list2.add(root1.val);
            getNode1(root1.right);
            return list2;
        }
    }

}
