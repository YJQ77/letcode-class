package com.example.demo.leetcode.suanfa;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/5/6 10:37
 */
public class let146 {
    class LRUCache {

        LinkedHashMap<Integer, Integer> map;
        int size;
        public LRUCache(int capacity) {
            size = capacity;
            map = new LinkedHashMap<>(capacity);
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Integer value = map.get(key);
                map.remove(key);
                map.put(key,value);
                return value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.size() == size && !map.containsKey(key)){
                Integer key1 = map.entrySet().iterator().next().getKey();
                map.remove(key1);
            }else{
                map.remove(key);
            }
            map.put(key,value);
        }
    }
}
