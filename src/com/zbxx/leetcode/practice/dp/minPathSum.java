package com.zbxx.leetcode.practice.dp;


/**
 * 64 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 */
public class minPathSum {

    /**
     * 这题和 机器人 mxn网格基本一样  不同的是求最短路径 那么最短路径 就是 左边和上边到达的最小加上当前的值
     * 但是这里有注意边界  因为第一行 或者第一列 只能选择左边或者上边
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        int f[] = new int[grid[0].length + 1];
        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[i - 1].length; j++) {
                if (j == 1) {
                    f[j] = f[j] + grid[i - 1][j - 1];
                } else if (i == 1) {
                    f[j] = f[j - 1] + grid[i - 1][j - 1];
                } else {
                    f[j] = Math.min(f[j - 1], f[j]) + grid[i - 1][j - 1];
                }
            }
        }
        return f[grid[0].length];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(matrix));
    }

}
