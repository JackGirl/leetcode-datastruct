package com.zbxx.leetcode.book.hash;


import java.util.HashMap;
import java.util.Map;

/**
 * leetcode book hash 字符串中第一个唯一字符
 */
public class hash_firstUniqChar {


    /**
     * 也可以用一个map 存下标列表  列表大小为1即无重复 再比较一个的index最小值
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> count = new HashMap<>();
        char[] sr = s.toCharArray();
        for (int i = 0; i < sr.length; i++) {
            Integer num = count.getOrDefault(sr[i], 0);
            if (num == 0) {
                map.put(sr[i], i);
            } else {
                map.remove(sr[i]);
            }
            count.put(sr[i], num + 1);
        }
        int min = Integer.MAX_VALUE;
        for (Integer value : map.values()) {
            min = Math.min(value, min);
        }
        return map.isEmpty() ? -1 : min;
    }

    public static void main(String[] args) {
        System.out.println(new hash_firstUniqChar().firstUniqChar("aabb"));
    }


}
