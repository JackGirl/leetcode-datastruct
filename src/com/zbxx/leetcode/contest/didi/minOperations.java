package com.zbxx.leetcode.contest.didi;

import java.util.TreeSet;

/**
 * 第 50 场双周赛 滴滴 最少操作使数组递增
 */
public class minOperations {


    public int minOperations(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        TreeSet<Integer> set = new TreeSet<>();
        set.add(nums[0]);
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            Integer last = set.pollLast();
            set.add(last);
            if (nums[i] <= last) {
                sum += last - nums[i] + 1;
                set.add(last + 1);
            } else {
                set.add(nums[i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] n = {1, 1, 1};
        System.out.println(new minOperations().minOperations(n));
    }


}
