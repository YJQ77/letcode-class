package com.example.demo.leetcode.suanfa;

/**
 * 描述：合并两个有序链表
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:04
 */
public class let21 {
    public static void main(String[] args) {

    }
    static class ListNode {
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

    static class Solution {
        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode node = new ListNode(0);
            ListNode pre = node;
            while (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    pre.next = l2;
                    l2 = l2.next;

                } else if (l1.val <= l2.val) {
                    pre.next = l1;
                    l1 = l1.next;

                }
                pre = pre.next;
            }
            pre.next = l1 == null ? l2 : l1;
            return node.next;
        }
    }
}
