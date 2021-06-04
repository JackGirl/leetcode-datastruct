package com.zbxx.leetcode;


/***
 * leetcode 学习>数组和字符串 翻转字符串
 */
public class arrayAndStr_reverseString {


    public void reverseString(char[] s) {
        if (s.length < 2) {
            return;
        }
        int i = 0;
        int r = s.length - 1;
        char t = 0;
        while (i < r) {
            t = s[r];
            s[r] = s[i];
            s[i] = t;
            i++;
            r--;
        }
    }

}
