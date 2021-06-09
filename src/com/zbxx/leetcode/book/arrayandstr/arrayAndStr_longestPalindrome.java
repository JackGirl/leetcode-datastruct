package com.zbxx.leetcode.book.arrayandstr;

/**
 *
 */
public class arrayAndStr_longestPalindrome {

    public static void main(String[] args) {
        arrayAndStr_longestPalindrome longestPalindrome = new arrayAndStr_longestPalindrome();
        String s = "bbaabb";
        System.out.println(longestPalindrome.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        char[] ar = s.toCharArray();
        int maxLength = 1;
        int left = 0;
        int right = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            int r = maxLength(i - 1, i + 1, ar);
            if (2 * r + 1 > maxLength) {
                left = i - r;
                right = i + r + 1;
                maxLength = 2 * r + 1;
            }
            if (ar[i] == ar[i + 1]) {
                int d = maxLength(i - 1, i + 2, ar);
                if (2 * d + 2 > maxLength) {
                    maxLength = 2 * d + 2;
                    left = i - d;
                    right = i + d + 2;
                }
            }
        }
        return s.substring(left, right);
    }

    public int maxLength(int start, int right, char[] ar) {
        int r = 0;
        while (start >= 0 && right < ar.length && ar[start] == ar[right]) {
            r++;
            start--;
            right++;
        }
        return r;
    }


}
