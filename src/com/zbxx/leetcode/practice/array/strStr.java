package com.zbxx.leetcode.practice.array;

public class strStr {

    /**
     * s主串  m子串
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int kmp(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        char[] mr = needle.toCharArray();
        int next[] = new int[mr.length];
        int len = 0;
        int start = 1;
        next[0] = -1;
        while (start < mr.length - 1) {
            if (len == -1 || (mr[start] == mr[len])) {
                len++;
                next[++start] = len;
            } else {
                len = next[len];
            }
        }
        char[] hr = haystack.toCharArray();
        int j = 0;
        for (int i = 0; i < hr.length; ) {
            if (j == mr.length - 1 && mr[j] == hr[i]) {
                return i - j;
            }
            if (j == -1) {
                j = 0;
                i++;
                continue;
            }
            if (mr[j] == hr[i]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return -1;
    }


}
