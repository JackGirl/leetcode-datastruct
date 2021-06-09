package com.zbxx.leetcode.book.arrayandstr;


/**
 * 寻找旋转排序数组的最小值
 */
public class arrayAndStr_findMin {


    public static void main(String[] args) {
        System.out.println(findMin(new int[]{1, 2}));
    }

    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int l = 0;
        int mid = nums.length / 2;
        int r = nums.length - 1;
        if (nums[l] < nums[mid] && nums[mid] < nums[r]) {
            return nums[l];
        }
        int start = mid;
        if (nums[l] < nums[mid]) {
            if (nums[r] < nums[mid]) {
                start = r;
            }
        }
        while (start > 0) {
            if (nums[start] < nums[start - 1]) {
                return nums[start];
            }
            start--;
        }
        return nums[start];
    }

}
