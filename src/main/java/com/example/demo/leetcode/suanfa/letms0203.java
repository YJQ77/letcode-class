package com.example.demo.leetcode.suanfa;

/**
 * 描述：面试题 02.03. 删除中间节点
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:39
 */
public class letms0203 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
