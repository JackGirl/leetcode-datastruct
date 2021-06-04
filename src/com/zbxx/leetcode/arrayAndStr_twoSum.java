package com.zbxx.leetcode;

/**
 * leetcode 学习>数组和字符串 有序数组找两个数等于target
 */
public class arrayAndStr_twoSum {


    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int i = 0;
        int r = numbers.length - 1;
        while (i < r) {
            if (numbers[i] + numbers[r] < target) {
                i++;
            } else if (numbers[i] + numbers[r] == target) {
                break;
            } else {
                r--;
            }
        }
        res[0] = i + 1;
        res[1] = r + 1;
        return res;
    }

}
