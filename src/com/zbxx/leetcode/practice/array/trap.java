package com.zbxx.leetcode.practice.array;


/**
 * leetcode  42 接雨水
 */
public class trap {


    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int[] leftMx = new int[height.length];
        int[] rightMx = new int[height.length];
        int lMax = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            leftMx[i] = Math.max(lMax, height[i]);
            lMax = leftMx[i];
        }
        int rMax = Integer.MIN_VALUE;
        for (int i = height.length - 1; i >= 0; i--) {
            rightMx[i] = Math.max(rMax, height[i]);
            rMax = rightMx[i];
        }

        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            if (leftMx[i] < height[i] || height[i] > rightMx[i]) {
                continue;
            }
            sum += Math.min(leftMx[i], rightMx[i]) - height[i];
        }

        return sum;
    }


}
