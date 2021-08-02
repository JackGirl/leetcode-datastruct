package com.zbxx.leetcode.practice.dp;


/**
 * 给定一个m x n 整数矩阵matrix ，找出其中 最长递增路径 的长度。
 * <p>
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/x2osfr/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class longestIncreasingPath {

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    //转移方程 为 上下左右小于当前矩阵值的 最大路径+1 但是因为前面的可能比后面大  后面避免重新计算 就使用数组保存记录
    public int longestIncreasingPath(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(dfs(visited, dp, matrix, i, j), max);
            }
        }
        return max;
    }


    private int dfs(boolean[][] visited, int[][] dp, int[][] matrix, int i, int j) {
        if (!visited[i][j]) {
            int max = 0;
            for (int k = 0; k < dirs.length; k++) {
                int xx = i + dirs[k][0];
                int yy = j + dirs[k][1];
                if (xx < 0 || xx > matrix.length - 1 || yy < 0 || yy > matrix[i].length - 1) {
                    continue;
                }
                if (matrix[xx][yy] < matrix[i][j]) {
                    max = Math.max(dfs(visited, dp, matrix, xx, yy), max);
                }
            }
            dp[i][j] = max + 1;
            visited[i][j] = true;
            return dp[i][j];
        } else {
            return dp[i][j];
        }
    }

    public static void main(String[] args) {
        longestIncreasingPath path = new longestIncreasingPath();
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(path.longestIncreasingPath(matrix));
    }

}
