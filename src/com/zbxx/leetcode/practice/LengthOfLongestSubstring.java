package com.zbxx.leetcode.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dsag43321e"));
    }

    public static int lengthOfLongestSubstring(String template) {
        Queue<Character> chars = new LinkedList<>();
        int maxLength = 0;
        for (char s : template.toCharArray()) {
            if (!chars.contains(s)) {
                chars.add(s);
                maxLength = Math.max(maxLength, chars.size());
            } else {
                boolean duplicate = true;
                while (duplicate || chars.size() == 0) {
                    char t = chars.poll();
                    if (s == t) {
                        duplicate = false;
                        chars.add(t);
                    }
                }
            }
        }
        return maxLength;
    }

}
