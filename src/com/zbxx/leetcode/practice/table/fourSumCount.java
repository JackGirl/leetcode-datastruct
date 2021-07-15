package com.zbxx.leetcode.practice.table;


import java.util.HashMap;
import java.util.Map;

/**
 * 四数之和
 */
public class fourSumCount {


    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        if (nums1.length == 0) {
            return 0;
        }
        Map<Integer, Integer> c = new HashMap<>();
        for (int n : nums1) {
            for (int k : nums2) {
                c.put(n + k, c.getOrDefault(n + k, 0) + 1);
            }
        }
        int r = 0;
        for (int n : nums3) {
            for (int k : nums4) {
                r += c.getOrDefault(-n - k, 0);
            }
        }
        return r;
    }


}
