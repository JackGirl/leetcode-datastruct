package com.zbxx.leetcode.book.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode book hash 同构字符串
 */
public class hash_isIsomorphic {


    public boolean isIsomorphic(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        s = resolver(s);
        t = resolver(t);
        return s.equals(t);
    }


    public String resolver(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] sr = s.toCharArray();
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < sr.length; i++) {
            Integer idx = map.getOrDefault(sr[i], i);
            map.put(sr[i], idx);
            rs.append(idx);
        }
        System.out.println(rs.toString());
        return rs.toString();
    }

    public static void main(String[] args) {
        hash_isIsomorphic isIsomorphic = new hash_isIsomorphic();
        System.out.println(isIsomorphic.isIsomorphic("abca", "cbdc"));
    }
}
