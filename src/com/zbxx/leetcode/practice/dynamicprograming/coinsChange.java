package com.zbxx.leetcode.practice.dynamicprograming;


import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
 * <p>
 * 你可以认为每种硬币的数量是无限的
 */
public class coinsChange {


    /**
     * 完全背包  也可以用bfs
     * 0
     * 1                2            5
     * 11 12 15      21 22  25        52 55  51
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        Arrays.sort(coins);
        for (int i = 1; i <= amount; i++) {
            //默认凑不成
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length && coins[j] <= i; j++) {
                if (f[i - coins[j]] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i - coins[j]] + 1, f[i]);
                }
            }
        }
        return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
    }


    public static void main(String[] args) {
        coinsChange coinsChange = new coinsChange();
        int[] coins = new int[]{2};
        int r = coinsChange.coinChange(coins, 3);
        System.out.println(r);
    }


}
