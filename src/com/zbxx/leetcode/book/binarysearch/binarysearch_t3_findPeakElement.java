package com.zbxx.leetcode.book.binarysearch;


/**
 * leetcode book binarySearch findPeakElement
 */
public class binarysearch_t3_findPeakElement {


    public static void main(String[] args) {
        int[] nmus = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(nmus));
    }

    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        int mid;

        while (l + 1 < r) {
            mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int rs = nums[l] > nums[r] ? l : r;
        return rs;
    }


}
