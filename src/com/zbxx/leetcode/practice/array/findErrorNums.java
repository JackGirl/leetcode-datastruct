package com.zbxx.leetcode.practice.array;


import java.util.Set;

/**
 * leetcode 645 错误的集合
 */
public class findErrorNums {


    /**
     * 因为n<10^4 所以能用求和 官方解  排序遍历、hash集合  确实快
     *
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        int sum = (nums.length * (nums.length + 1)) / 2;
        int reduplicate = 0;
        int s = 0;
        for (int num : nums) {
            int r = nums[Math.abs(num) - 1];
            if (r < 0) {
                reduplicate = Math.abs(num);
            }
            s += Math.abs(num);
            nums[Math.abs(num) - 1] *= -1;
        }
        int result[] = new int[2];
        result[0] = reduplicate;
        result[1] = reduplicate + sum - s;
        return result;
    }

}
