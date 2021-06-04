package com.zbxx.leetcode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode数组和字符串  连续和大于等于target
 */
public class minSubArrayLen {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(new minSubArrayLen().minSubArrayLen(11, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return 1;
            }
            queue.add(nums[i]);
            sum += nums[i];
            if (sum >= target) {
                while (sum >= target) {
                    min = min == 0 ? queue.size() : Math.min(queue.size(), min);
                    sum -= queue.poll();
                }
            }
        }
        return min;
    }

}
