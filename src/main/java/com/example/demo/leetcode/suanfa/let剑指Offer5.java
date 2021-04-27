package com.example.demo.leetcode.suanfa;


/**
 * 描述：剑指 Offer 05. 替换空格
 *
 * @author yinjiaqi
 * @date 2021/4/27 14:02
 */
public class let剑指Offer5 {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars){
            if (c == ' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
