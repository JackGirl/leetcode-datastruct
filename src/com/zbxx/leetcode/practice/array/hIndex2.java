package com.zbxx.leetcode.practice.array;


/**
 * H指数 ||
 */
public class hIndex2 {


    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        int h = 0;
        int l = 0;
        int mid = 0;
        int r = citations.length - 1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            int d = citations.length - mid;
            if (d <= citations[mid]) {
                h = Math.max(h, d);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return h;
    }

    public static void main(String[] args) {
        hIndex2 hIndex2 = new hIndex2();
        int r = hIndex2.hIndex(new int[]{
                0, 1, 3, 5, 6
        });
        System.out.println(r);
    }


}
