package com.zbxx.leetcode.practice.dp;


/**
 * 63不同路径2
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class uniquePathsWithObstacles {


    /**
     * 因为加了障碍物  所以有障碍物的  显然就是零表示不能到达
     * 这里使用一维数组是状态亚索  当前状态只依赖上一层和前一个
     *
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] f = new int[obstacleGrid[0].length + 1];
        f[1] = 1;
        for (int i = 1; i <= obstacleGrid.length; i++) {
            for (int j = 1; j <= obstacleGrid[i - 1].length; j++) {
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    f[j] = 0;
                } else {
                    f[j] = f[j - 1] + f[j];
                }
            }
        }
        return f[obstacleGrid[0].length];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(matrix));
    }

}
