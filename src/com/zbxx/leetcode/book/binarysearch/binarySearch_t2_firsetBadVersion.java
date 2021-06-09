package com.zbxx.leetcode.book.binarysearch;

public class binarySearch_t2_firsetBadVersion {


    static boolean[] s = {true, true, true, true, false, false, false, false, false};

    public static void main(String[] args) {
        System.out.println(firstBadVersion(s.length));
    }

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left <= n && isBadVersion(left)) {
            return left;
        } else {
            return -1;
        }
    }


    public static boolean isBadVersion(int x) {
        return !s[x - 1];
    }


}
