package com.zbxx.leetcode.book.binarysearch;


/**
 * leetcode book>二分查找
 */
public class binarySearch_guessNumber {


    static int x = 996;


    public static void main(String[] args) {
        System.out.println(guessNumber(1500));
    }

    public static int guessNumber(int n) {
        int left = 1;
        int right = n;
        int mid;
        int r;
        while (left <= right) {
            mid = left + (right - left) / 2;
            r = guess(mid);
            if (r == 0) {
                return mid;
            } else if (r > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


    public static int guess(int n) {
        return Integer.compare(996, n);
    }


}
