package com.zbxx.leetcode.book.binarysearch;


/**
 * leetcode  数组重复元素
 */
public class binarySearch_findDuplicate {


    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int a = Math.abs(nums[i]);
            if (nums[a] < 0) {
                return a;
            }
            nums[a] *= -1;
        }
        return -1;
    }


}
