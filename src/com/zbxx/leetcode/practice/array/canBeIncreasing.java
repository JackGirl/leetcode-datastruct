package com.zbxx.leetcode.practice.array;


/**
 * 删除一个数保证数据连续上升
 */
public class canBeIncreasing {

    public boolean canBeIncreasing(int[] nums) {
        int max = nums[0];
        boolean find = false;
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= max) {
                if (!find) {
                    find = true;
                    if (i < 2 || i >= 2 && nums[i] > nums[i - 2]) {
                        max = nums[i];
                    }
                } else {
                    return false;
                }
            } else {
                max = nums[i];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new canBeIncreasing().canBeIncreasing(new int[]{1, 2, 3}));
    }

}
