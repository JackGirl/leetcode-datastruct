package com.zbxx.leetcode.practice.array;


import java.util.HashSet;
import java.util.Set;

/**
 * leetcode book  中级算法  矩阵置零
 */
public class setZeroes {


    /**
     * 可以复制矩阵  修改复制矩阵的  也可以遍历 把要修改的坐标存起来 然后修改
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            boolean find = false;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; !find && k < matrix[i].length; k++) {
                        set.add(i * matrix[i].length + k);
                    }
                    find = true;
                    for (int k = 0; k < matrix.length; k++) {
                        set.add(k * matrix[i].length + j);
                    }
                }

            }
        }

        for (Integer integer : set) {
            int x = integer / (matrix[0].length);
            int y = integer % (matrix[0].length);
            matrix[x][y] = 0;
        }
    }


    public static void main(String[] args) {
        setZeroes setZeroes = new setZeroes();
        int[][] s = {{0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}};
        setZeroes.setZeroes(s);
    }


}
