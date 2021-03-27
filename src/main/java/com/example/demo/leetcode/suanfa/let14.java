package com.example.demo.leetcode.suanfa;

/**
 * 描述：最长公共前缀
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:03
 */
public class let14 {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if(strs.length==0 || strs[0].length()==0) return "";
            if(strs.length==1) return strs[0];
            char[] chars = strs[0].toCharArray();
            StringBuffer sb = new StringBuffer();
            StringBuffer result = new StringBuffer();
            int count = 0;
            for (int i = 0; i < strs[0].length(); i++) {
                sb = sb.append(String.valueOf(chars[i]));
                for (int j = 1; j < strs.length; j++) {
                    if (strs[j].startsWith(sb.toString())) {
                        count++;
                    } else {
                        count = 0;
                        break;
                    }
                }
                if (count == 0) {
                    break;
                }else{
                    result = result.append(String.valueOf(chars[i]));
                }
            }
            return  result.toString();
        }
    }
}
