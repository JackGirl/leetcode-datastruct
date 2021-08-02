package com.zbxx.leetcode.practice.dp;


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
        cost[2] = cost[2] + Math.min(cost[0], cost[1]);
        for (int i = 3; i < cost.length; i++) {
            cost[i] = cost[i] + Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }


}
