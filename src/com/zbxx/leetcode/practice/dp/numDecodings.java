package com.zbxx.leetcode.practice.dp;


/**
 * 91 。解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 */
public class numDecodings {


    /**
     * 输入：s = "12"
     * 输出：2
     * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
     * 当前数可以单独解码或者如果能和前一个数一起解码那就再加1
     *
     * @param s
     * @return
     */
    public static int numDecodings(String s) {
        char[] sr = s.toCharArray();
        if (sr[0] == '0') {
            return 0;
        }
        int dp[] = new int[s.length() + 1];
        dp[1] = 1;
        dp[0] = 1;
        for (int i = 2; i <= sr.length; i++) {
            int pre = ((sr[i - 2] - '0') * 10 + (sr[i - 1] - '0'));
            if (sr[i - 1] == '0') {
                if (pre < 30 && pre >= 10) {
                    dp[i] = dp[i - 2];
                } else {
                    return 0;
                }
            } else {
                if (pre <= 26 && pre >= 10) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[s.length()];
    }


    public static void main(String[] args) {
        System.out.println(numDecodings("2222"));
    }

}
