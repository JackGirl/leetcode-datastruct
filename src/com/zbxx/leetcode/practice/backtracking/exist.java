package com.zbxx.leetcode.practice.backtracking;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * book中级算法 单词搜索
 */
public class exist {


    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Set<Integer> visited = new HashSet<>();
                boolean r = backTracking(board, visited, i, j, word, 0);
                if (r) {
                    return true;
                }
            }
        }
        return false;
    }


    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * dfs
     *
     * @param visited
     */
    public boolean backTracking(char[][] board, Set<Integer> visited, int nextI, int nextJ, String word, int step) {

        visited.add(nextI * board[nextI].length + nextJ);
        char s = board[nextI][nextJ];

        if (s != word.charAt(step)) {
            return false;
        }
        if (s == word.charAt(step) && step == word.length() - 1) {
            return true;
        }
        for (int[] dir : dirs) {
            int x = nextI + dir[0];
            int y = nextJ + dir[1];
            if (x < 0 || y < 0 || x > board.length - 1 || y > board[x].length - 1 ||
                    visited.contains(x * board[x].length + y)) {
                continue;
            }
            boolean r = backTracking(board, visited, x, y, word, step + 1);
            if (r) {
                return r;
            }
            visited.remove(x * board[x].length + y);
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] s = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}};
        //char [][] s= {{'a','a'}  };,


        System.out.println(new exist().exist(s, "ABCESEEEFS"));
    }

}
