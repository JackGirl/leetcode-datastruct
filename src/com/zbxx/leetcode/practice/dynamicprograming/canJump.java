package com.zbxx.leetcode.practice.dynamicprograming;


/**
 * book 中级算法 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 */
public class canJump {


    public boolean canJump(int[] nums) {
        int maxJump = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxJump < i) {
                return false;
            }
            maxJump = Math.max(i + nums[i], maxJump);
        }
        return true;
    }


}
