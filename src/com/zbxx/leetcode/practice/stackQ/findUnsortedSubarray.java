package com.zbxx.leetcode.practice.stackQ;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 581 最短无序子数组
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <p>
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class findUnsortedSubarray {


    /**
     * 这题可以用排序  然后比对最早 和最晚不一样值的下标求出  nlogn
     * 题目进阶为O(n) 标签是单调栈  然后又想到了 单调递增栈解决
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        int minIdx = Integer.MAX_VALUE;
        int maxIdx = 0;
        int maxNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (!stack.isEmpty() && nums[i] < maxNum) {
                maxIdx = i;
                while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                    minIdx = Math.min(minIdx, stack.pop());
                }
            }
            maxNum = Math.max(maxNum, nums[i]);
            stack.push(i);
        }
        return maxIdx < minIdx ? 0 : maxIdx - minIdx + 1;
    }

    public static void main(String[] args) {
        findUnsortedSubarray findUnsortedSubarray = new findUnsortedSubarray();
        System.out.println(findUnsortedSubarray.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }


}
