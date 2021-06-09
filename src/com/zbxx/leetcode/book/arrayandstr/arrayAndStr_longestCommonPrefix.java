package com.zbxx.leetcode.book.arrayandstr;


import java.util.Arrays;
import java.util.Comparator;

/**
 * leetcode 学习 字符串和数组  最长公共前缀
 */
public class arrayAndStr_longestCommonPrefix {

    public static void main(String[] args) {
        arrayAndStr_longestCommonPrefix longestCommonPrefix = new arrayAndStr_longestCommonPrefix();
        String[] sr = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix.longestCommonPrefix(sr));
    }

    public String longestCommonPrefix(String[] sr) {
        Arrays.sort(sr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        int length = 0;
        for (int i = 0; i < sr[0].length(); i++) {
            boolean equals = true;
            char pre = sr[0].charAt(i);
            for (int j = 1; j < sr.length; j++) {
                char t = sr[j].charAt(i);
                if (t != pre) {
                    equals = false;
                    break;
                }
            }
            if (!equals) {
                break;
            }
            length++;
        }
        return sr[0].substring(0, length);
    }

}
