package com.zbxx.leetcode;


/**
 * leetcode 动态规划 746 最小花费爬楼梯
 */
public class minCostClimbingStairs {


    public static void main(String[] args) {
        int s[] = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(s));
    }

    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int dp[] = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        dp[2] = cost[2] + Math.min(dp[0], dp[1]);
        for (int i = 3; i < cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        dp[cost.length] = Math.min(dp[cost.length - 1], dp[cost.length - 2]);
        return dp[cost.length];
    }


}
