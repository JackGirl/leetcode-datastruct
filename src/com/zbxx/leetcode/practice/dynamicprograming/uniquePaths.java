package com.zbxx.leetcode.practice.dynamicprograming;


/**
 * book 中级算法 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 */
public class uniquePaths {

    /**
     * 这题dfs也能做
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m + 1][n + 1];
        f[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = Math.max(f[i - 1][j] + f[i][j - 1], f[i][j]);
            }
        }
        return f[m][n];
    }


}
