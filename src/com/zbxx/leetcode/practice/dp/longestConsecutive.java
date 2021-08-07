package com.zbxx.leetcode.practice.dp;

import java.util.Arrays;
import java.util.TreeSet;


/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class longestConsecutive {

    /**
     * 思路 :前一个数等于当前数-1  当前数最大值为 前一个数最大值加1  否则为1
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            treeSet.add(nums[i]);
        }
        int max = 1;
        int pre = treeSet.pollFirst();
        int preMax = 1;
        while (!treeSet.isEmpty()) {
            int t = treeSet.pollFirst();
            if (t - 1 == pre) {
                max = Math.max(preMax + 1, max);
                preMax++;
            } else {
                preMax = 1;
            }
            pre = t;
        }
        return max;
    }

    /*public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 1;
        int dp[] = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int t = 0;
            for (int k = i - 1; k >=0 && nums[k] >= nums[i] - 1; k--) {
                t = Math.max(dp[k], t);
            }
            dp[i] = t + 1;
            max = Math.max(max,dp[i]);
        }
        return max;
    }*/
    public static void main(String[] args) {
        int nums[] = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
}
