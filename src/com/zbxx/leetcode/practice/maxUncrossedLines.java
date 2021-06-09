package com.zbxx.leetcode.practice;


/**
 * 不相交的线 1035
 */
public class maxUncrossedLines {


    public static void main(String[] args) {
        int[] nums1 = {1, 3, 7, 1, 7, 5}, nums2 = {1, 9, 2, 5, 1};
        System.out.println(maxUncrossedLines(nums1, nums2));
    }


    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int minArr[] = nums1.length > nums2.length ? nums2 : nums1;
        int maxArr[] = nums1.length > nums2.length ? nums1 : nums2;
        int dp[][] = new int[minArr.length][maxArr.length];
        int pre = 0;
        int px = 0;
        for (int k = 0; k < maxArr.length; k++) {
            if (k < minArr.length) {
                if (maxArr[0] == minArr[k]) {
                    px = 1;
                } else {

                }
                dp[k][0] = px;
            }
            if (maxArr[k] == minArr[0]) {
                pre = 1;
            }
            dp[0][k] = pre;
        }

        for (int n = 1; n < dp.length; n++) {
            for (int k = 1; k < dp[n].length; k++) {
                if (maxArr[k] == minArr[n]) {
                    dp[n][k] = dp[n - 1][k - 1] + 1;
                } else {
                    dp[n][k] = Math.max(dp[n - 1][k], dp[n][k - 1]);
                }
            }
        }
        return dp[minArr.length - 1][maxArr.length - 1];
    }

}
