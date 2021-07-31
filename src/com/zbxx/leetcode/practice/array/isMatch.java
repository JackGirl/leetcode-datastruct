package com.zbxx.leetcode.practice.array;


/**
 * 10 正则表达式匹配
 */
public class isMatch {


    public static boolean isMatch(String s, String p) {
        if (s.length() == 0) {
            return true;
        }
        if (p.length() == 0) {
            return false;
        }
        char[] sr = s.toCharArray();
        char[] pr = p.toCharArray();
        boolean[][] match = new boolean[sr.length + 1][pr.length + 1];
        match[0][0] = true;
        for (int i = 0; i <= sr.length; i++) {
            for (int j = 1; j <= pr.length; j++) {
                if (pr[j - 1] == '*') {
                    match[i][j] = match[i][j - 2];
                    if (i > 0 && (pr[j - 2] == sr[i - 1] || pr[j - 2] == '.')) {
                        match[i][j] = match[i][j - 2] || match[i - 1][j - 2] || match[i - 1][j];
                    }
                } else {
                    if (i > 0 && (pr[j - 1] == sr[i - 1] || pr[j - 1] == '.')) {
                        match[i][j] = match[i - 1][j - 1];
                    }
                }
            }
        }
        return match[sr.length][pr.length];
    }


    public static void main(String[] args) {
        System.out.println(isMatch("aab", "c*a*b"));
    }


}
