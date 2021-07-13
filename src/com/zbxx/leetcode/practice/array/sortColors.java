package com.zbxx.leetcode.practice.array;


import java.util.Arrays;

/**
 * book  中级算法颜色排序
 */
public class sortColors {


    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        for (int i = l; i <= r; ) {
            if (nums[i] == 0) {
                swap(nums, l, i);
                l++;
            } else if (nums[i] == 2) {
                swap(nums, r, i);
                r--;
                continue;
            }
            i++;
        }

    }

    private void swap(int[] nums, int i, int k) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }

    public static void main(String[] args) {
        sortColors sortColors = new sortColors();
        int res[] = new int[]{2, 0, 2, 1, 1, 0, 1, 2, 1, 2, 1, 1, 1, 1, 0, 0};
        sortColors.sortColors(res);
        System.out.println(Arrays.toString(res));

    }


}
