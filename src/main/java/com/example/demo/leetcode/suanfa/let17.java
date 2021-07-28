package com.example.demo.leetcode.suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

/**
 * 描述：电话号码的字母组合
 *
 * @author yinjiaqi
 * @date 2021/7/28 13:39
 */
public class let17 {

    public static void main(String[] args) {
        System.out.println(letterCombinations("235"));
    }
    public static List<String> letterCombinations(String digits) {
        Map<Character,List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a","b","c"));
        map.put('3', Arrays.asList("d","e","f"));
        map.put('4', Arrays.asList("g","h","i"));
        map.put('5', Arrays.asList("j","k","l"));
        map.put('6', Arrays.asList("m","n","o"));
        map.put('7', Arrays.asList("p","q","r","s"));
        map.put('8', Arrays.asList("t","u","v"));
        map.put('9', Arrays.asList("w","x","y","z"));
        if(digits.equals("")) return Collections.emptyList();
        if (digits.length()==1) return map.get(digits.charAt(0));
        List<String> zuhe = new ArrayList<>();
        for (int i = 0;i<digits.length();){
            if (i==0){
                zuhe = zuhe(map.get(digits.charAt(i)), map.get(digits.charAt(i + 1)));
                i=i+2;
            }else{
                zuhe =  zuhe(zuhe, map.get(digits.charAt(i)));
                i=i+1;
            }

        }
        return zuhe;
    }

    public static List<String> zuhe(List<String> a1,List<String> a2){
        List<String> list = new ArrayList<>();
        for (String s : a1) {
            for (String s1 : a2) {
                list.add(s+s1);
            }
        }
        return list;
    }
}
