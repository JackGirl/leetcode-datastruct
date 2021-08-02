package com.zbxx.leetcode.practice.dp;


/**
 * 子数组最大和
 */
public class maxSubArray {

    /**
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = 0;
        if (nums.length == 0) {
            return max;
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i - 1] + nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }


}
