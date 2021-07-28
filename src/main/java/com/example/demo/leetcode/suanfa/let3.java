package com.example.demo.leetcode.suanfa;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：无重复字符的最长子串
 *
 * @author yinjiaqi
 * @date 2021/7/20 14:22
 */
public class let3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0,start = 0;
        for (int end = 0 ;end<s.length();end++){
            if (map.containsKey(s.charAt(end))){
                start = Math.max(map.get(s.charAt(end))+1,start);
            }
            max = Math.max(max,end-start+1);
            map.put(s.charAt(end),end);
        }
        return max;
    }
}
