package com.example.demo.leetcode.suanfa;

import java.util.Stack;

/**
 * 描述：基本计算器 II
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:05
 */
public class let227 {
    class Solution {
        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            int n = s.length();
            int num = 0;
            char sign = '+';
            for (int i = 0; i < n; i++) {
                if (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i)-'0';
                }
                if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == n - 1) {
                    switch (sign) {
                        case '+':
                            stack.push(num);
                            break;
                        case '-':
                            stack.push(-num);
                            break;
                        case '*':
                            stack.push(stack.pop() * num);
                            break;
                        case '/':
                            stack.push(stack.pop() / num);
                            break;
                    }
                    sign = s.charAt(i);
                    num = 0;
                }
            }
            int result = 0;
            while (!stack.isEmpty()){
                result = result+stack.pop();
            }
            return result;
        }
    }
}
