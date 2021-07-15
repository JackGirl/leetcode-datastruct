package com.zbxx.leetcode.practice.array;


import java.util.*;

/**
 * 回旋镖的数量
 */
public class numberOfBoomerangs {


    /**
     * @param points
     * @return
     */
    public int numberOfBoomerangs(int[][] points) {
        int rs = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> p = new HashMap<>();
            for (int j = i - 1; j >= 0; j--) {
                int k = calculate(points[i], points[j]);
                p.put(k, p.getOrDefault(k, 0) + 1);
            }
            for (int j = i + 1; j < points.length; j++) {
                int k = calculate(points[i], points[j]);
                p.put(k, p.getOrDefault(k, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> integerIntegerEntry : p.entrySet()) {
                System.out.println(integerIntegerEntry.getKey());
                rs += count(integerIntegerEntry.getValue());
            }
        }

        return rs;


    }


    private int calculate(int[] p1, int[] p2) {
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        return dx * dx + dy * dy;
    }


    private int count(int n) {
        System.out.println(n);
        return n * (n - 1);
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        System.out.println(new numberOfBoomerangs().numberOfBoomerangs(points));
    }


}
