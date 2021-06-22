package com.zbxx.leetcode.book.queueAndstack;


import java.util.Deque;
import java.util.LinkedList;


/**
 * leetcode book 栈和队列  更新01矩阵
 */
public class queueAndStack_bfs_updateMatrix {


    public static void main(String[] args) {
        int[][] s = {{0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 1, 1}, {1, 0, 0, 0, 1}};
        updateMatrix(s);
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                System.out.println(s[i][j]);
            }
        }
    }

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    /**
     * bfs从零开始  那么每个非更新1 长度都是一层层渲染   从1开始找零  不一定是最短的 有多个零
     *
     * @param mat
     * @return
     */
    public static int[][] updateMatrix(int[][] mat) {
        if (mat.length == 0) {
            return mat;
        }
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        Deque<int[]> deque = new LinkedList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    deque.offer(new int[]{i, j});
                }
            }
        }
        while (!deque.isEmpty()) {
            int[] di = deque.poll();
            int x = di[0];
            int y = di[1];
            for (int[] t : dirs) {
                int dx = x + t[0];
                int dy = y + t[1];
                if (dx < mat.length && dx >= 0 && dy < mat[0].length && dy >= 0 && !visited[dx][dy]) {
                    mat[dx][dy] = mat[x][y] + 1;
                    visited[dx][dy] = true;
                    deque.offer(new int[]{dx, dy});
                }
            }
        }
        return mat;
    }


}
