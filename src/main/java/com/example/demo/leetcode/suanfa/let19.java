package com.example.demo.leetcode.suanfa;

/**
 * 描述：删除链表的倒数第 N 个结点
 *
 * @author yinjiaqi
 * @date 2021/7/28 15:05
 */
public class let19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0;i<n ; i++){
            first = first.next;
        }
        while (first!=null){
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        return dummy.next;

    }
    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
