package com.zbxx.leetcode.book.binarysearch;

/**
 * 二分查找
 */
public class binarySearch_search {


    public static void main(String[] args) {
        int[] nums = {-1, 0, 5};
        int target = 5;
        System.out.println(search(nums, target));
    }


    public static int search(int[] nums, int target) {
        int index = -1;
        if (nums.length == 0) {
            return index;
        }
        int mid = nums.length / 2;
        int start = 0;
        int end = nums.length - 1;

        while (mid >= start && mid <= end) {
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                index = mid;
                break;
            }
            mid = (start + end) / 2;
        }
        return index;
    }


}
