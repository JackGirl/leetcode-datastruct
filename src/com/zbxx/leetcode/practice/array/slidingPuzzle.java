package com.zbxx.leetcode.practice.array;


import java.util.*;

/**
 * leetcode 773.滑动谜题
 */
public class slidingPuzzle {


    public static void main(String[] args) {
        int[][] board = {{3, 2, 4}, {1, 5, 0}};
        System.out.println(slidingPuzzle(board));
    }

    public static int slidingPuzzle(int[][] board) {
        int x = 0, y = 0;
        final String fstr = "123450";
        /**
         * 起点
         */
        String s = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    x = i;
                    y = j;
                }
                s += board[i][j] + "";
            }
        }
        Set<String> visited = new HashSet<>();
        visited.add(s);
        Deque<int[]> deque = new LinkedList<>();
        Deque<String> v = new LinkedList<>();
        v.offer(s);
        deque.offer(new int[]{x, y});
        deque.offer(null);
        v.offer(null);
        int num = 0;
        int[][] ps = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!deque.isEmpty()) {
            String curstr = v.poll();
            if (curstr != null && curstr.equals(fstr)) {
                return num;
            }
            int[] point = deque.poll();
            if (point == null) {
                num++;
                if (!deque.isEmpty()) {
                    deque.offer(null);
                    v.offer(null);
                }
            } else {
                int xx = point[0];
                int yy = point[1];
                for (int i = 0; i < ps.length; i++) {
                    int nx = xx + ps[i][0];
                    int ny = yy + ps[i][1];
                    String t;
                    if ((t = check(xx * board[0].length + yy, nx * board[0].length + ny, nx, ny, curstr, visited)) != null) {
                        visited.add(t);
                        v.offer(t);
                        deque.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return -1;
    }

    public static String check(int x, int y, int nx, int ny, String s, Set<String> visited) {
        if (nx < 0 || nx > 1 || ny < 0 || ny > 2) {
            return null;
        }
        char[] sr = s.toCharArray();
        char t = sr[x];
        sr[x] = sr[y];
        sr[y] = t;
        String nstr = new String(sr);
        if (!visited.contains(nstr)) {
            return nstr;
        }
        return null;
    }


}
