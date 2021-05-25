package com.zbxx.leetcode;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 学习>数组和字符串 合并区间
 */
public class arrayAndStr_merge {


    public static void main(String[] args) {
        arrayAndStr_merge merge = new arrayAndStr_merge();
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.toString(merge.merge(arr)));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Queue<int[]> newQueue = new LinkedList<>();
            int[] temp = intervals[i];
            while (!queue.isEmpty()) {
                int[] s = queue.poll();
                if (s[1] >= temp[0] && temp[1] >= s[0]) {
                    temp[0] = Math.min(s[0], temp[0]);
                    temp[1] = Math.max(s[1], temp[1]);
                } else {
                    newQueue.add(s);
                }
            }
            newQueue.add(temp);
            queue = newQueue;
            newQueue = null;
        }
        int[][] t = new int[queue.size()][2];
        int i = 0;
        while (!queue.isEmpty()) {
            t[i] = queue.poll();
            i++;
        }
        return t;
    }

}
