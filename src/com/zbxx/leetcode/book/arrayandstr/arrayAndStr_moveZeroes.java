package com.zbxx.leetcode.book.arrayandstr;


import java.util.Arrays;

/**
 * leetcode 数组和字符串  移动零
 */
public class arrayAndStr_moveZeroes {


    public static void main(String[] args) {

        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        int t = nums[j];
                        nums[j] = 0;
                        nums[i] = t;
                        break;
                    }
                }
            }
        }
    }


}
