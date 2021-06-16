package com.zbxx.leetcode.book.binarysearch;

/**
 * leetcode book>二分查找  寻找最小值（包含重复元素）
 */
public class binarySearch_findMin2 {


    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        System.out.println(fidMin(arr));
    }


    public static int fidMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (nums[mid] < nums[l]) {
                r = mid;
            } else if (nums[mid] > nums[l]) {
                if (nums[mid] > nums[r]) {
                    l = mid + 1;
                } else {
                    return nums[l];
                }
            } else if (nums[mid] == nums[l]) {
                if (nums[mid] < nums[r]) {
                    r = mid;
                } else if (nums[mid] == nums[r]) {
                    r--;
                } else {
                    l = mid + 1;
                }
            }
        }
        return nums[l];
    }


}
