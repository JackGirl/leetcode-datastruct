package com.zbxx.leetcode.book.arrayandstr;


/**
 * leetcode 数组与字符串 学习 如果发现矩阵中元素为零将上行与列全部清零
 */
public class arrayAndStr_setZeros {


    public static void main(String[] args) {
        arrayAndStr_setZeros setZeros = new arrayAndStr_setZeros();
        int[][] arr = {
                {1, 1, 1}
                , {1, 0, 1}
                , {1, 1, 1}};
        setZeros.setZeroes(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int[][] contain = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0 && contain[i][j] == 0) {
                    for (int k = 0; k < matrix[i].length; k++) {
                        if (matrix[i][k] != 0) {
                            matrix[i][k] = 0;
                            contain[i][k] = 1;
                        }
                    }
                    for (int k = 0; k < matrix.length; k++) {
                        if (matrix[k][j] != 0) {
                            matrix[k][j] = 0;
                            contain[k][j] = 1;
                        }
                    }
                }
            }
        }
    }


}
