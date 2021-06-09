package com.zbxx.leetcode.practice;

import java.util.HashMap;
import java.util.Map;


/**
 * leetcode 532. 连续子数组求和 是否为K倍数
 */
public class checkSubarraySum {


    public static void main(String[] args) {
        checkSubarraySum checkSubarraySum = new checkSubarraySum();
        int[] arr = {23, 2, 4, 6, 7};
        checkSubarraySum.checkSubarraySum(arr, 6);
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> keys = new HashMap<>();
        keys.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int t = sum % k;
            if (keys.containsKey(t)) {
                if (i - keys.get(t) >= 2) {
                    return true;
                }
            } else {
                keys.put(t, i);
            }
        }
        return false;
    }


/*
    public boolean checkSubarraySum(int[] nums, int k) {
        long [] sum = new long[nums.length+1];

        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1]+nums[i-1];
        }
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
               long t =  sum[j+1]-sum[i];
                if (t%k==0) {
                    return true;
                }
            }
        }
        return false;
    }*/

}
