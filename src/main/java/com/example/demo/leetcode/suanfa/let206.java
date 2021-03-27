package com.example.demo.leetcode.suanfa;

/**
 * 描述：反转链表
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:05
 */
public class let206 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            return reverse(null, head);
        }

        public  ListNode reverse(ListNode pre, ListNode cur) {
            if (cur == null) return pre;
            ListNode next = cur.next;
            cur.next = pre;
            return reverse(cur, next);
        }
    }
}
