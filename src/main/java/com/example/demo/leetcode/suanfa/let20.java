package com.example.demo.leetcode.suanfa;

import java.util.Stack;

/**
 * 描述：有效的括号
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:04
 */
public class let20 {
    class Solution {
        public boolean isValid(String s) {
            int i = s.length() / 2;
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(') stack.push(')');
                else if (c == '[') stack.push(']');
                else if (c == '{') stack.push('}');
                else if (stack.isEmpty() || c != stack.pop()) return false;
            }

            return stack.isEmpty();
        }
    }
}
