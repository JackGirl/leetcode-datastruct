package com.zbxx.leetcode.practice.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 397  整数替换
 * 这题感觉跟dp 没啥很大关系  纯递归
 */
public class integerReplacement {


    Map<Integer, Integer> map = new HashMap<>();


    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (map.containsKey(n - 1)) {
            return map.get(n - 1);
        } else {
            if (n % 2 == 0) {
                int c = integerReplacement(n / 2) + 1;
                map.put(n - 1, c);
                return c;
            } else {
                int c = integerReplacement((n - 1)) + 1;
                long d = n;
                d++;
                int t = integerReplacement((int) (d / 2)) + 2;
                map.put(n - 1, Math.min(c, t));
                return Math.min(c, t);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new integerReplacement().integerReplacement(100000000));
    }

}
