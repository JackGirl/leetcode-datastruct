package com.zbxx.leetcode.practice.array;


/**
 * leetcode 数组分类 1476 子矩阵查询
 * 最多有 500 次updateSubrectangle 和 getValue 操作。
 * 1 <= rows, cols <= 100
 * rows == rectangle.length
 * cols == rectangle[i].length
 * 0 <= row1 <= row2 < rows
 * 0 <= col1 <= col2 < cols
 * 1 <= newValue, rectangle[i][j] <= 10^9
 * 0 <= row < rows
 * 0 <= col < cols
 */
public class SubrectangleQueries {

    int[][] values;
    int     preValue;
    int     row_1;
    int     col_1;
    int     row_2;
    int     col_2;

    public SubrectangleQueries(int[][] rectangle) {
        this.values = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        if (newValue == preValue) {
            if (row1 <= row_1 || row2 >= row_1 || col1 >= col_1 || col2 >= col_2) {
                for (int i = row1; i <= row2; i++) {
                    for (int k = col1; k <= col2; k++) {
                        values[i][k] = newValue;
                    }
                }
                this.row_1 = row1;
                this.row_2 = row2;
                this.col_1 = col1;
                this.col_2 = col2;
            }
        } else {
            for (int i = row1; i <= row2; i++) {
                for (int k = col1; k <= col2; k++) {
                    values[i][k] = newValue;
                }
            }
            this.row_1 = row1;
            this.row_2 = row2;
            this.col_1 = col1;
            this.col_2 = col2;
        }

    }

    public int getValue(int row, int col) {
        return values[row][col];
    }

}
