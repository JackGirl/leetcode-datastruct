package com.zbxx.leetcode.contest.didi;


import java.util.Arrays;

/**
 * 第 50 场双周赛 统计一个圆中点的数目
 */
public class countPoints {

    public int[] countPoints(int[][] points, int[][] queries) {
        int result[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int sum = 0;
            int r = queries[i][2];
            int x = queries[i][0];
            int y = queries[i][1];
            for (int j = 0; j < points.length; j++) {
                double xx = Math.abs(x - points[j][0]) * Math.abs(x - points[j][0]);
                double yy = Math.abs(y - points[j][1]) * Math.abs(y - points[j][1]);
                double sub = Math.sqrt(xx + yy);
                if (sub <= r) {
                    sum++;
                }
            }
            result[i] = sum;
        }
        return result;
    }


    public static void main(String[] args) {
        countPoints countPoints = new countPoints();
        int p[][] = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};
        int queries[][] = {{1, 2, 2}, {2, 2, 2}, {4, 3, 2}, {4, 3, 3}};
        System.out.println(Arrays.toString(countPoints.countPoints(p, queries)));
    }
}
