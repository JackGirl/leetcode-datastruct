package com.zbxx.leetcode.book.binarysearch;


/**
 * leetcode book>二分查找  mySqrt
 */
public class binarySearch_mySqrt {


    public static void main(String[] args) {
        System.out.println(mysqrt(7));
    }

    public static int mysqrt(int x) {
        if (x == 1 || x == 0) {
            return x;
        }
        int start = 1;
        int end = x;
        int mid;
        int r;
        while (start <= end) {
            mid = start + (end - start) / 2;
            r = x / mid;
            if (r > mid) {
                start = mid + 1;
            } else if (r < mid) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return end;
    }


}
