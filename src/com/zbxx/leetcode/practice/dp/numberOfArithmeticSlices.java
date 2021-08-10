package com.zbxx.leetcode.practice.dp;


/**
 * 413 。 等差数列划分 每日一题 dp
 */
public class numberOfArithmeticSlices {


    /**
     *
     */
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        int pre = nums[1] - nums[0];
        dp[1] = 1;
        dp[2] = 2;
        int sum = 0;
        for (int i = 3; i <= nums.length; i++) {
            if (nums[i - 1] - nums[i - 2] == pre) {
                dp[i] = dp[i - 1] + 1;
                if (dp[i] >= 3) {
                    sum += dp[i] - 3 + 1;
                }
            } else {
                pre = nums[i - 1] - nums[i - 2];
                dp[i] = 2;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new numberOfArithmeticSlices().numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5, 6}));
    }


}
