package com.zbxx.leetcode.practice.dp;


/**
 * leetcode  11 maxArea 盛最多水的容器
 */
public class maxArea {

    public static void main(String[] args) {
        int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7, 3, 11, 4, 9, 1, 3, 3, 5, 45, 3};
        System.out.println(new maxArea().maxArea(height));
    }

    public int maxArea(int[] height) {
        int preHeight = 0;
        int preMax = 0;
        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] > preHeight) {
                preMax = Math.max(preMax, findMax(i, height));
                preHeight = height[i];
            }
        }
        return preMax;
    }

    private int findMax(int start, int[] height) {
        int right = height.length - 1;
        int preMax = 0;
        while (right > start) {
            int min = Math.min(height[start], height[right]);
            preMax = Math.max(min * (right - start), preMax);
            right--;
        }
        return preMax;
    }

}
