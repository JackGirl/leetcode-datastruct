package com.zbxx.leetcode.practice.dp;


/**
 * 通配符匹配 44 这题跟isMatch基本一样   限制还少了  *不需要和前一位配合
 * <p>
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 */
public class isMatch {


    public boolean isMatch(String s, String p) {
        boolean match[][] = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    match[i][j] = match[i][j - 1];
                    if (i > 0) {
                        match[i][j] = match[i][j] || match[i - 1][j];
                    }
                } else {
                    if (i > 0 && (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1))) {
                        match[i][j] = match[i - 1][j - 1];
                    }
                }
            }
        }

        return match[s.length()][p.length()];
    }


}
