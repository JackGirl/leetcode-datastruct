package com.zbxx.leetcode.practice.array;


import java.util.Arrays;

/**
 * leetcode 1409 查询带建的排列
 */
public class processQueries {


    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 1};
        System.out.println(Arrays.toString(new processQueries().processQueries(arr, 5)));
    }


    public int[] processQueries(int[] queries, int m) {
        if (queries.length == 0) {
            return new int[0];
        }
        int[] res = new int[queries.length];
        int[] indexArr = new int[m + 1];
        int[] sourceArr = new int[m + 1];
        for (int i = 1; i < indexArr.length; i++) {
            indexArr[i] = i;
            sourceArr[i] = i;
        }
        for (int i = 0; i < queries.length; i++) {
            res[i] = indexArr[queries[i]] - 1;
            for (int j = indexArr[queries[i]]; j > 1; j--) {
                //先交换index  再交换 数据
                int preIndex = indexArr[sourceArr[j - 1]];
                indexArr[sourceArr[j - 1]] = indexArr[sourceArr[j]];
                indexArr[sourceArr[j]] = preIndex;
                //交换source

                int t = sourceArr[j - 1];
                sourceArr[j - 1] = sourceArr[j];
                sourceArr[j] = t;
            }
        }
        return res;
    }


}
