package com.zbxx.leetcode.book.hash;


import java.util.*;

/**
 * leetcode book hash 字母异位词分组
 */
public class hash_groupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = key(str);
            List<String> list = map.getOrDefault(key, new LinkedList<>());
            list.add(str);
            map.put(key, list);
        }
        List<List<String>> list = new LinkedList<>();
        for (List<String> value : map.values()) {
            list.add(value);
        }
        return list;
    }

    private String key(String str) {
        char[] sr = str.toCharArray();
        Arrays.sort(sr);
        return new String(sr);
    }

    public static void main(String[] args) {
        System.out.println(new hash_groupAnagrams().key("eat"));
    }

}
