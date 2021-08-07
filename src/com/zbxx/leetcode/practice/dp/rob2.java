package com.zbxx.leetcode.practice.dp;


/**
 * 213 。打家劫舍2
 */
public class rob2 {


    /**
     * 第一家和最后一家不能都偷
     * 那就分两种情况
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] f1 = new int[nums.length - 1];
        int[] f2 = new int[nums.length - 1];
        f1[0] = nums[0];
        f1[1] = Math.max(nums[0], nums[1]);

        f2[0] = nums[1];
        f2[1] = Math.max(nums[1], nums[2]);

        for (int i = 2; i < nums.length - 1; i++) {
            f1[i] = Math.max(f1[i - 2] + nums[i], f1[i - 1]);
        }
        for (int i = 3; i < nums.length; i++) {
            f2[i - 1] = Math.max(f2[i - 3] + nums[i], f2[i - 2]);
        }
        return Math.max(f1[nums.length - 2], f2[nums.length - 2]);
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 2};
        System.out.println(rob(nums));
    }

}
