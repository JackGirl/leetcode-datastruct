package com.zbxx.leetcode.practice.array;


import java.util.Arrays;

/**
 * leetcode 1833 雪糕的最大数量
 */
public class maxIceCream {

    public static void main(String[] args) {
        int[] arr = {1, 6, 3, 1, 2, 5};
        System.out.println(new maxIceCream().maxIceCream(arr, 20));
    }

    public int maxIceCream(int[] costs, int coins) {
        if (costs.length == 0) {
            return 0;
        }
        Arrays.sort(costs);
        int sum = 0;
        int num = 0;
        for (int i = 0; i < costs.length; i++) {
            sum += costs[i];
            if (sum > coins) {
                return num;
            }
            num++;
        }
        return num;
    }


}
