package com.zbxx.leetcode.practice.math;


import java.util.HashMap;
import java.util.Map;

/**
 * book 中级算法分数到小数
 */
public class fractionToDecimal {


    public static String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 1) {
            return "" + numerator;
        }

        long a = numerator < 0 ? -Long.valueOf(numerator) : numerator;
        long b = denominator < 0 ? -Long.valueOf(denominator) : denominator;
        boolean v = false;
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            v = true;
        }
        StringBuilder builder = new StringBuilder();
        if (v) {
            builder.append("-");
        }
        builder.append(a / b);
        long overflow = a % b;
        if (overflow > 0) {
            builder.append(".");
            Map<Long, Integer> kesMap = new HashMap<>();
            String s = recursion(overflow, b, new StringBuilder(), kesMap);
            builder.append(s);
        }
        return builder.toString();
    }

    private static String recursion(long num, long denominator, StringBuilder builder, Map<Long, Integer> kesMap) {
        if (kesMap.containsKey(num % denominator)) {
            builder.insert(kesMap.get(num % denominator), "(");
            builder.append(")");
            return builder.toString();
        }
        kesMap.put(num % denominator, builder.length());
        num *= 10;
        builder.append(num / denominator);
        if (num % denominator == 0) {
            return builder.toString();
        } else {
            return recursion(num % denominator, denominator, builder, kesMap);
        }

    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(Integer.MIN_VALUE, -1));
    }

}
