package com.zbxx.leetcode.book.queueAndstack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * leetcode book queueAndStack 完全平方数
 */
public class queueAndStack_bfs_numSquares {

    public static void main(String[] args) {
        System.out.println(numSquares(7168));
    }

    public static int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(0);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                Integer t = queue.poll();
                for (int j = 1; j <= n; j++) {
                    Integer s = t + j * j;
                    if (s == n) {
                        return depth;
                    }
                    if (s > n) {
                        break;
                    }
                    if (!visited.contains(s)) {
                        queue.add(s);
                        visited.add(s);
                    }
                }
            }
        }
        return -1;
    }


}
