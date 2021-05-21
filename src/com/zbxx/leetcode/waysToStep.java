package com.zbxx.leetcode;


/**
 * leetcode 08.01 三步问题
 */
public class waysToStep {


    public static void main(String[] args) {
        System.out.println(waysToStep(5));
    }

    public static int waysToStep(int n) {
        if (n == 1) {
            return n;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        int max = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] + (dp[i - 2] + dp[i - 3]) % max) % max;
        }
        return dp[n];
    }


}
