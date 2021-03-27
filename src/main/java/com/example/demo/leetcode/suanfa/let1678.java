package com.example.demo.leetcode.suanfa;

/**
 * 描述：设计 Goal 解析器
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:37
 */
public class let1678 {
    class Solution {
        public String interpret(String command) {
            return command.replace("()","o").replace("(al)","al");
        }
    }
}
