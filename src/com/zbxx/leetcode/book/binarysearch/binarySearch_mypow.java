package com.zbxx.leetcode.book.binarysearch;


/**
 * leetcode 开方结果
 */
public class binarySearch_mypow {


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(myPow(2.00000, -10));
    }


    public static double myPow(double x, int n) {
        int pw = Math.abs(n);
        if (pw == 0) {
            return 1;
        }

        double rs = calculate(x, pw, 1, x);
        if (n < 0) {
            rs = 1 / rs;
        }
        return rs;
    }

    private static double calculate(double x, int n, int r, double source) {
        if (n == 1) {
            return x;
        }
        if (n / 2 > r) {
            return calculate(x * x, n, 2 * r, source);
        } else {
            int t = n - r;
            int overflow = n % 2;
            return x * calculate(source, t - overflow, 1, source) * (overflow == 1 ? source : 1);
        }
    }


}
