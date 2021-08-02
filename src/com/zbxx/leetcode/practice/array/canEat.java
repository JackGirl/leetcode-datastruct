package com.zbxx.leetcode.practice.array;


import java.util.Arrays;

/**
 * leetcode 1744 6.1 吃糖果
 */
public class canEat {


    public static void main(String[] args) {
        canEat canEat = new canEat();
        int[] arr = {7, 4, 5, 3, 8};
        int[][] queries = {{0, 2, 2}, {4, 2, 4}, {2, 13, 1000000000}};
        System.out.println(Arrays.toString(canEat.canEat(arr, queries)));
        ;
    }

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        if (queries.length == 0 || candiesCount.length == 0) {
            return new boolean[0];
        }
        boolean[] result = new boolean[queries.length];
        long sums[] = new long[candiesCount.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + candiesCount[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            int type = queries[i][0];
            int day = queries[i][1] + 1;
            int num = queries[i][2];
            long min = (sums[type] / num) + 1;
            long max = sums[type + 1];
            result[i] = day >= min && day <= max;
        }
        return result;
    }


}
