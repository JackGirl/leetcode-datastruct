package com.zbxx.leetcode;


import java.util.Arrays;

/**
 * leetcode 学习 数组和字符串 二维数组 旋转矩阵
 * <p>
 * <p>
 * ..直接硬编码   快速的方法是直接两个双层循环  先对角反转 然后镜像翻转
 */
public class arrayAndStr_rotate {

    public static void main(String[] args) {
        arrayAndStr_rotate rotate = new arrayAndStr_rotate();
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void rotate(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int start = 0;
        int maxY = matrix.length - 1;
        for (int i = 0; i < matrix.length / 2; i++) {
            int index = start;
            int maxLength = maxY - start + 1;
            int rightSource[] = new int[maxLength];
            int topSource[] = new int[maxLength];
            int bottomSource[] = new int[maxLength];
            int leftSource[] = new int[maxLength];

            for (int j = 0; j < maxLength; j++) {
                rightSource[j] = matrix[j + index][maxY];
                bottomSource[j] = matrix[maxY][maxY - j];
                leftSource[j] = matrix[maxY - j][index];
                topSource[j] = matrix[index][j + index];
            }
            //右边
            for (int j = 0; j < maxLength; j++) {
                matrix[j + index][maxY] = topSource[j];
            }
            //下边
            for (int j = 0; j < maxLength; j++) {
                matrix[maxY][maxY - j] = rightSource[j];
            }
            //左边
            for (int j = 0; j < maxLength; j++) {
                matrix[maxY - j][index] = bottomSource[j];
            }

            //上边
            for (int j = 0; j < maxLength; j++) {
                matrix[index][index + j] = leftSource[j];
            }


            start++;
            maxY--;
        }


    }
}
