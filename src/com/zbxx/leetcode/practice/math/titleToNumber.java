package com.zbxx.leetcode.practice.math;


import java.util.HashMap;
import java.util.Map;

/**
 * Excel表列序号
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 */
public class titleToNumber {
    final static Map<Character, Integer> map = new HashMap<>();


    static {
        int idx = 1;
        for (int i = 65; i <= 90; i++) {
            map.put((char) i, idx++);
        }
    }


    /**
     * *  其实就是 26进制转为 十进制
     *
     * @param columnTitle
     * @return
     */
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        if (columnTitle.length() == 0) {
            return sum;
        }
        char[] sr = columnTitle.toCharArray();
        for (int k = sr.length - 1; k >= 0; k--) {
            int t = map.get(sr[k]);
            long n = sr.length - 1 - k;
            n = (long) Math.pow(26, n);
            sum += t * n;
        }
        return sum;
    }


    public static void main(String[] args) {
        titleToNumber titleToNumber = new titleToNumber();
        System.out.println(titleToNumber.titleToNumber("ZY"));
        ;
    }

}
