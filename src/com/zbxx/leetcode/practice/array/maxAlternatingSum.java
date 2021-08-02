package com.zbxx.leetcode.practice.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 交替数组和
 */
public class maxAlternatingSum {

    public long maxAlternatingSum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        long odd[] = new long[nums.length];
        long event[] = new long[nums.length];
        event[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            odd[i] = Math.max(event[i - 1] - nums[i], odd[i - 1]);
            event[i] = Math.max(event[i - 1] + nums[i], event[i - 1]);
        }
        return Math.max(event[nums.length - 1], odd[nums.length - 1]);
    }

    public static void main(String[] args) {
        maxAlternatingSum maxAlternatingSum = new maxAlternatingSum();
        System.out.println(maxAlternatingSum.maxAlternatingSum(new int[]{3, 2, 9, 2, 10}));
    }


}
