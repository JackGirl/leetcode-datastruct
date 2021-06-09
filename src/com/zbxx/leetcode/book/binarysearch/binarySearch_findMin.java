package com.zbxx.leetcode.book.binarysearch;

public class binarySearch_findMin {


    public static void main(String[] args) {
        int nums[] = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums));
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
        while (l < r) {
            mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            } else if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }


}
