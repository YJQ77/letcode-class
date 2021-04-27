package com.example.demo.leetcode.suanfa;

import io.swagger.models.auth.In;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy.Definition;

/**
 * 描述：剑指 Offer 06. 从尾到头打印链表
 *
 * @author yinjiaqi
 * @date 2021/4/27 14:02
 */
public class let剑指Offer6 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int[] reversePrint(ListNode head) {
            LinkedList<Integer> linkedList = new LinkedList<>();
            while (head!=null){
                linkedList.addFirst(head.val);
                head = head.next;
            }
            int[] result = new int[linkedList.size()];
            int i = 0;
            for (Integer key : linkedList){
                result[i++] = key;
            }
            return result;
        }
    }
}
