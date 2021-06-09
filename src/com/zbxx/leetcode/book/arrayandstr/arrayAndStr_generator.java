package com.zbxx.leetcode.book.arrayandstr;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 杨辉三角
 */
public class arrayAndStr_generator {


    public static void main(String[] args) {
        /*List<List<Integer>> t = generate(6);
        for (List<Integer> integers : t) {
            System.out.println(Arrays.toString(integers.toArray()));
        }*/

        System.out.println(Arrays.toString(t(3).toArray()));

    }


    public static List<List<Integer>> generate(int numRows) {
        List<Integer> pre = new ArrayList<>();
        List<List<Integer>> all = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> s = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                int t = j - 2;
                if (j == i) {
                    s.add(1);
                } else if (t >= 0) {
                    s.add(pre.get(t) + pre.get(j - 1));
                } else {
                    s.add(j);
                }
            }
            pre = s;
            all.add(pre);
        }
        return all;
    }


    public static List<Integer> t(int rowIndex) {
        List<Integer> all = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i < rowIndex + 1; i++) {
            all.add(1);
        }

        for (int i = 1; i <= rowIndex + 1; i++) {
            int pre = 1;
            for (int j = 1; j <= i; j++) {
                int t = j - 2;
                if (j == 1 || j == i) {
                    all.set(j - 1, 1);
                } else {
                    int temp = all.get(j - 1);
                    all.set(j - 1, temp + pre);
                    pre = temp;
                }
            }
        }
        return all;
    }


}
