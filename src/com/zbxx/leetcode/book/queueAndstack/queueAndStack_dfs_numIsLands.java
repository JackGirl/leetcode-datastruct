package com.zbxx.leetcode.book.queueAndstack;


/**
 * leetcode book queueAndStack 寻找岛屿
 */
public class queueAndStack_dfs_numIsLands {


    public static void main(String[] args) {
        char gripd[][] = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(numIslands(gripd));
    }


    public static int numIslands(char[][] grid) {
        int r = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    r++;
                    bfs(grid, i, j);
                }
            }
        }
        return r;
    }

    private static void bfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            //top
            bfs(grid, i - 1, j);
            //left
            bfs(grid, i, j - 1);
            //bottom
            bfs(grid, i + 1, j);
            ;
            //right
            bfs(grid, i, j + 1);
        }

    }


}
