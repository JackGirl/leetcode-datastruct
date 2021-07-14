package com.zbxx.leetcode.practice.math;


/**
 * 中级算法 两数相除  不用乘法 除法  MOD
 */
public class divide {

    public int divide(int dividend, int divisor) {

        if (divisor == 1) {
            return dividend;
        }
        if (divisor == Integer.MIN_VALUE) {
            return (dividend == Integer.MIN_VALUE) ? 1 : 0;
        }

        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return -dividend;
            }
        }
        boolean v = true;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            v = false;
        }
        long res = calculate(dividend > 0 ? -dividend : dividend, divisor > 0 ? -divisor : divisor);
        if (!v) {
            res *= -1;
        }
        return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
    }

    private long calculate(long a, long b) {
        if (a > b) {
            return 0;
        }
        long min = 1;
        long t = b;
        while (t + t >= a) {
            min = min + min;
            t += t;
        }
        return min + calculate(a - t, b);
    }

    public static void main(String[] args) {
        divide divide = new divide();
        int r = divide.divide(-1, Integer.MIN_VALUE);
        System.out.println(r);
    }


}
