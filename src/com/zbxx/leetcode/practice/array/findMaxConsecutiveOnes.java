package com.zbxx.leetcode.practice.array;


/**
 * leetcode 数组和字符串 最大连续的1
 */
public class findMaxConsecutiveOnes {


    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                nums[i] += nums[i - 1];
                max = Math.max(nums[i], max);
            }
        }
        return max;
    }


}
