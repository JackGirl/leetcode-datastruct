package com.zbxx.leetcode.practice;

/**
 * leetcode 26 数组重复元素 返回新的长度
 */
public class removeDuplicates {


    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int s = removeDuplicates(nums);
        for (int i = 0; i < s; i++) {
            System.out.println(nums[i]);
        }
    }


    public static int removeDuplicates(int[] nums) {
        int index = 1;
        int s = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (s == nums[i]) {
                continue;
            } else {
                nums[index++] = nums[i];
                s = nums[i];
            }
        }
        return index;
    }

}


