package com.zbxx.leetcode.practice.dp;


/**
 * 45 动添规划 跳跃游戏
 */
public class jump2 {


    public int jump(int[] nums) {
        int[] f = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] >= i - j) {
                    min = Math.min(f[j], min);
                }
            }
            f[i] = min + 1;
        }
        return f[nums.length - 1];
    }


    public static void main(String[] args) {
        jump2 jump2 = new jump2();
        int r = jump2.jump(new int[]{2, 3, 1, 1, 4});
        System.out.println(r);
    }


}
