package com.zbxx.leetcode.book.bst;


import java.util.TreeSet;


/**
 * leetcode book bst 存在重复元素
 */
public class bst_containsNearbyAlmostDuplicate {


    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length == 0 || k == 0) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long n = nums[i] * 1L;
            Long l = set.floor(n);
            Long r = set.ceiling(n);
            if (l != null && n - l <= t) {
                return true;
            }
            if (r != null && r - n <= t) {
                return true;
            }
            if (i >= k) {
                set.remove(nums[i - k] * 1L);
            }
            set.add(n);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] ar = new int[]{1, 2};
        System.out.println(containsNearbyAlmostDuplicate(ar, 0, 1));
    }


}
