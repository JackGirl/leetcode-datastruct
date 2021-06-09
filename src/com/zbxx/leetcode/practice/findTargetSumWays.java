package com.zbxx.leetcode.practice;


/**
 * leetcode 494 目标和
 */
public class findTargetSumWays {


    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }


    public static int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int[] a = new int[1];
        calculate(nums, target, a, 0, 0);
        return a[0];
    }

    public static void calculate(int[] nums, int target, int[] a, int sum, int index) {
        if (index == nums.length) {
            if (sum == target) {
                a[0]++;
            }
            return;
        }
        calculate(nums, target, a, (sum + nums[index]), (index + 1));
        calculate(nums, target, a, (sum - nums[index]), (index + 1));
    }


}
