package com.zbxx.leetcode.book.arrayandstr;

import java.util.Arrays;


/**
 * leetcode 学习 数组和字符串 对角线遍历
 */
public class arrayAndStr_findDiagonalOrder {


    public static void main(String[] args) {
        arrayAndStr_findDiagonalOrder findDiagonalOrder = new arrayAndStr_findDiagonalOrder();
        int[][] arr = {
                {1, 2, 3, 9},
                {4, 5, 6, 11},
                {7, 8, 9, 4}
        };
        System.out.println(Arrays.toString(findDiagonalOrder.findDiagonalOrder(arr)));
    }


    public int[] findDiagonalOrder(int[][] mat) {
        int[] t = new int[mat.length * mat[0].length];
        if (mat.length == 0) {
            return t;
        }
        t[0] = mat[0][0];
        int x = 0;
        int y = 0;
        boolean right = true;
        int index = 1;
        while (index < t.length) {
            while (right && x < t.length) {
                int newx = x - 1;
                int newy = y + 1;
                if (newx < 0 || newy >= mat[0].length) {
                    newx++;
                    while (newy >= mat[0].length) {
                        newx++;
                        newy--;
                    }
                    right = false;
                }
                t[index++] = mat[newx][newy];
                x = newx;
                y = newy;
            }
            while (!right && index < t.length) {
                int newx = x + 1;
                int newy = y - 1;
                if (newy < 0 || newx >= mat.length) {
                    newy++;
                    while (newx >= mat.length) {
                        newx--;
                        newy++;
                    }
                    right = true;
                }
                t[index++] = mat[newx][newy];
                x = newx;
                y = newy;
            }

        }
        return t;

    }

}
