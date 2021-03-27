package com.example.demo.leetcode.suanfa;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：用队列实现栈
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:05
 */
public class let225 {
    class MyStack {

        private List<Integer> list = null;
        /** Initialize your data structure here. */
        public MyStack() {
            list = new ArrayList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            list.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int i = list.get(list.size()-1);
            list.remove(list.size()-1);
            return i;
        }

        /** Get the top element. */
        public int top() {
            int i = list.get(list.size()-1);
            return i;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return list.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
