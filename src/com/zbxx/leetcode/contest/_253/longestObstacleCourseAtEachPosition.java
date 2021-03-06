package com.zbxx.leetcode.contest._253;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class longestObstacleCourseAtEachPosition {


    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] ans = new int[obstacles.length];
        ans[0] = 1;
        int len = 1;
        int dp[] = new int[obstacles.length + 1];
        dp[1] = obstacles[0];
        for (int i = 1; i < obstacles.length; i++) {
            if (obstacles[i] >= dp[len]) {
                ans[i] = ++len;
                dp[len] = obstacles[i];
            } else {
                int l = 0;
                int r = len;
                while (l + 1 < r) {
                    int mid = l + (r - l) / 2;
                    if (dp[mid] <= obstacles[i]) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                if (dp[r] <= obstacles[i]) {
                    dp[r + 1] = obstacles[i];
                    ans[i] = r + 1;
                } else if (dp[l] <= obstacles[i]) {
                    dp[l + 1] = obstacles[i];
                    ans[i] = l + 1;
                }

            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new longestObstacleCourseAtEachPosition().longestObstacleCourseAtEachPosition(new int[]{5, 1, 5, 5, 1, 3, 4, 5, 1, 4})));
    }


}
