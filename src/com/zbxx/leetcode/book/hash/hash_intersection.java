package com.zbxx.leetcode.book.hash;


import java.util.HashSet;
import java.util.Set;

/**
 * leetcode book hash  两个数组的交集
 */
public class hash_intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> data = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                data.add(nums2[i]);
            }
        }
        int[] result = new int[data.size()];
        int index = 0;
        for (Integer datum : data) {
            result[index++] = datum;
        }
        return result;
    }


}
