package com.zbxx.leetcode;

/**
 * 最大子数组arr leetcode 动态规划 16.17面试题
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.max(arr[i], arr[i] + arr[i - 1]);
            max = Math.max(arr[i], max);
        }
        return max;
    }


}
