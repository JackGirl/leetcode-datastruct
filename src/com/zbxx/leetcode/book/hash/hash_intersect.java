package com.zbxx.leetcode.book.hash;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * leetcode book hash  两个数组的交集 II
 */
public class hash_intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> num = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            num.put(nums1[i], num.getOrDefault(nums1[i], 0) + 1);
        }
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++) {
            Integer numCount = num.get(nums2[i]);
            if (numCount != null) {
                Integer putCount = count.getOrDefault(nums2[i], 0);
                if (numCount > putCount) {
                    result.add(nums2[i]);
                    count.put(nums2[i], putCount + 1);
                }
            }
        }
        int arr[] = new int[result.size()];
        int idx = 0;
        for (Integer integer : result) {
            arr[idx++] = integer;
        }
        return arr;
    }


}
