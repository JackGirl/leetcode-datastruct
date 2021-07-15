package com.zbxx.leetcode.practice.table;


import java.util.HashMap;
import java.util.Map;

/**
 * 直线上最多的点数
 */
public class maxPoints {


    /**
     * 同一条直线 斜率相等
     * 斜率 2/4  1/2都是一样的  要化成最小的  所以找到最小公约数 再除
     *
     * @param points
     * @return
     */
    public int maxPoints(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> pm = new HashMap<>();
            int max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int dy = points[j][1] - points[i][1];
                int dx = points[j][0] - points[i][0];
                int k = gcd(dy, dx);
                int d = pm.getOrDefault(dy / k + "-" + dx / k, 0) + 1;
                pm.put(dy / k + "-" + dx / k, d);
                max = Math.max(max, d);
            }
            res = Math.max(res, max + 1);
        }

        return res;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);

    }
}
