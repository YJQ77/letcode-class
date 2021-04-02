package com.example.demo.leetcode.suanfa;

/**
 * 描述：两两交换链表中的节点
 *
 * @author yinjiaqi
 * @date 2021/4/1 19:23
 */
public class let24 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head==null || head.next == null){
                return head;
            }
            ListNode next = head.next;
            head.next = swapPairs(next.next);
            next.next = head;
            return next;

        }
    }
}
