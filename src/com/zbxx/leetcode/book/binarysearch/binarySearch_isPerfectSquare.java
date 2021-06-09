package com.zbxx.leetcode.book.binarysearch;


/**
 * leetcode book 二分查找 是否完全平方数
 */
public class binarySearch_isPerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
    }


    public static boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) {
            return true;
        }
        int r = num / 2;
        int l = 2;
        int mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            double s = (double) num / mid;
            if (s == mid) {
                return true;
            }
            if (s < mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        double s = (double) num / l;
        return s == l;
    }

}
