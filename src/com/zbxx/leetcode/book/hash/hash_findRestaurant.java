package com.zbxx.leetcode.book.hash;


import java.util.*;

/**
 * leetcode book hash 两个列表的最小索引总和
 */
public class hash_findRestaurant {


    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        Set<String> result = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            Integer idx = map.get(list2[i]);
            if (idx != null) {
                int t = idx + i;
                if (t < min) {
                    min = t;
                    result.clear();
                    result.add(list2[i]);
                }
                if (t == min) {
                    result.add(list2[i]);
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }

}
