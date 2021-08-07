package com.zbxx.leetcode.practice.array;

/**
 * 异或数组
 */
public class XorOperation {

    public static void main(String[] args) {
        System.out.println(xorOperation(5, 0));
    }


    public static int xorOperation(int n, int start) {
        int left = 0;
        int right = n - 1;
        int result = 0;
        while (left < right) {
            result ^= start + left * 2;
            result ^= start + right * 2;
            left++;
            right--;
        }
        if (left == right) {
            result ^= start + left * 2;
        }
        return result;
    }


}
