package com.example.demo.leetcode.suanfa;

import com.example.demo.elsfk.fk.S;
import com.sun.org.apache.xpath.internal.objects.XString;
import java.util.Stack;
import org.springframework.util.StringUtils;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/4/12 16:51
 */
public class let1047 {

    public static void main(String[] args) {
        String s = removeDuplicates("abbaca");
        System.out.println(s);
    }

    public static String removeDuplicates(String S) {
        char[] c = S.toCharArray();
        Stack stack = new Stack();
        for (int i = 0; i < c.length; i++) {
            if (stack.empty()) {
                stack.push(c[i]);
                continue;
            }
            Object pop = stack.pop();
            if (pop.equals(c[i])){
                continue;
            }else{
                stack.push(pop);
                stack.push(c[i]);
            }
        }
        String s = "";
        while (!stack.empty()){
            char pop = (char) stack.pop();
            s= String.valueOf(pop)+s; //效率最高的方法
        }
        return s;
    }
}
