package com.zbxx.leetcode.practice.array;


/**
 * . 在排序数组中查找数字 I
 */
public class search2 {

    public static int search(int[] nums, int target) {
        int ans = 0;
        if (nums.length == 0) {
            return ans;
        }
        int l = 0;
        int r = nums.length - 1;
        int idx = -1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (nums[l] == target) {
            idx = l;
        } else if (nums[r] == target) {
            idx = r;
        }
        if (idx != -1) {
            while (idx < nums.length && nums[idx++] == target) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }


}
