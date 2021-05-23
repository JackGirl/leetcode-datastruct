package com.zbxx.leetcode;

public class lengthOfLIS {

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(arr));
    }


    public static int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = 1;
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            int m = 0;
            for (int k = 0; k < i; k++) {
                if (nums[k] < nums[i]) {
                    m = Math.max(m, dp[k]);
                }
            }
            dp[i] = m + 1;
            max = Math.max(dp[i], max);
        }
        return max;
    }


}
