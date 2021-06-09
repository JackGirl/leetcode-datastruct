package com.zbxx.leetcode.book.binarysearch;


import java.util.Arrays;

/**
 * leetcode boo
 */
public class binarySearch_t3_searchRange {


    public static void main(String[] args) {
        int[] nums = {5, 8, 8};
        System.out.println(Arrays.toString(searchRange(nums, 8)));
        ;
    }


    public static int[] searchRange(int[] nums, int target) {
        int[] s = new int[2];
        s[0] = -1;
        s[1] = -1;
        if (nums.length == 0) {
            return s;
        }
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l + 1 < r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                r = mid;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        if (nums[l] == target) {
            s[0] = l;
            s[1] = l;
        } else if (nums[r] == target) {
            s[0] = r;
            s[1] = r;
        }

        for (int i = s[0] + 1; i < nums.length; i++) {
            if (nums[i] == target) {
                s[1] = i;
            } else {
                break;
            }
        }
        return s;
    }

}
