package com.zbxx.leetcode.contest._254;

import java.util.*;

public class rearrangeArray {


    /**
     * 重新排列数组  i到 numslength-1下标的数都小于两边和的平均
     *
     * @param nums
     * @return
     */
    public static int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[nums.length];
        int l = 0;
        int r = nums.length - 1;
        int idx = 0;
        while (l <= r) {
            ans[idx++] = nums[l];
            if (l != r) {
                ans[idx++] = nums[r];
            }
            l++;
            r--;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rearrangeArray(new int[]{6, 2, 0, 9, 7})));

    }

}
