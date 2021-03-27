package com.example.demo.leetcode.suanfa;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 描述：合并二叉树
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:05
 */
public class let590 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };


    class Solution {
        public List<Integer> postorder(Node root) {
            LinkedList list = new LinkedList();
            Stack<Node> stack = new Stack<>();
            if(root == null) return list;
            stack.push(root);
            while(!stack.isEmpty()){
                root = stack.pop();
                list.addFirst(root.val);
                stack.addAll(root.children);
            }
            return list;
        }
    }

}
