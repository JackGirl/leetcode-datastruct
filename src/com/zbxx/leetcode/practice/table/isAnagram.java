package com.zbxx.leetcode.practice.table;


import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母疑惑词
 */
public class isAnagram {


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] sr = s.toCharArray();
        char[] tr = t.toCharArray();
        for (int i = 0; i < sr.length; i++) {
            map.put(sr[i], map.getOrDefault(sr[i], 0) + 1);
            map.put(tr[i], map.getOrDefault(tr[i], 0) - 1);
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            if (characterIntegerEntry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }


}
