package com.zbxx.leetcode;

import java.util.Arrays;

public class TwoSum {


    public static void main(String[] args) {
        int[] arr = {1, 2, 77, 3, 9, 0, 6};
        System.out.println(Arrays.toString(twoSum(arr, 99)));
        ;
    }

    /**
     * 两数和
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        if (nums == null && nums.length < 2) {
            throw new RuntimeException("no index");
        }
        if (nums.length == 2) {
            if (nums[0] + nums[1] == target) {
                index[0] = 0;
                index[1] = 1;
            }
        } else {
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        index[0] = i;
                        index[1] = j;
                    }
                }

            }
        }
        return index;
    }
}
