package com.zbxx.leetcode.practice.array;


import java.util.Arrays;

/**
 * leetcode 每日一题
 */
public class hIndex {

    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int ph = 0;
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (h <= citations[i]) {
                ph = Math.max(h, ph);
            }
        }
        return ph;
    }

    public static void main(String[] args) {
        hIndex hIndex = new hIndex();
        System.out.println(hIndex.hIndex(new int[]{3, 0, 6, 1, 5, 7, 8, 90, 12}));
        ;


    }


}
