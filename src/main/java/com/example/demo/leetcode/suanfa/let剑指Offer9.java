package com.example.demo.leetcode.suanfa;

import java.util.Stack;

/**
 * 描述：剑指 Offer 09. 用两个栈实现队列
 *
 * @author yinjiaqi
 * @date 2021/4/27 16:13
 */
public class let剑指Offer9 {
    class CQueue {
        Stack<Integer> stack1 ;
        Stack<Integer> stack2 ;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
               stack1.push(value);
        }

        public int deleteHead() {
              if (stack2.empty()){
                  while (!stack1.empty()){
                      stack2.push(stack1.pop());
                  }
              }
              if(stack2.empty()){
                  return -1;
              }
              return stack2.pop();
        }
    }
}
