package com.zbxx.leetcode.practice.array;

import java.util.HashMap;
import java.util.Map;


/**
 * leetcode 525 连续数组  给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度
 */
public class findMaxLength {

    public static void main(String[] args) {
        System.out.println(new findMaxLength().findMaxLength(new int[]{0, 1, 0}));
    }

    public int findMaxLength(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int sum[] = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            if (nums[i - 1] == 0) {
                sum[i] = -1;
            } else {
                sum[i] = 1;
            }
        }
        int s = sum[0];
        int max = 0;
        Map<Integer, Integer> m = new HashMap<>();
        m.put(s, 0);
        for (int k = 1; k < sum.length; k++) {
            s += sum[k];
            Integer r = m.get(s);
            if (r != null) {
                max = Math.max(k - r, max);
            } else {
                m.put(s, k);
            }
        }
        return max;
    }

}
