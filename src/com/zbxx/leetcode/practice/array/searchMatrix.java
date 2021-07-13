package com.zbxx.leetcode.practice.array;


/**
 * book 中级算法 搜索二维矩阵
 */
public class searchMatrix {


    public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix, 0, 0, matrix[0].length - 1, target);
    }


    private boolean search(int[][] matrix, int floor, int start, int end, int target) {
        if (floor > matrix.length - 1 || start < 0 || end > matrix[floor].length - 1 || start > end) {
            return false;
        }
        int[] data = matrix[floor];
        int l = start;
        int r = end;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid] == target) {
                return true;
            } else if (target < data[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        int d = data[l];
        if (d == target) {
            return true;
        }
        return d > target ? search(matrix, floor + 1, start, l - 1, target) : search(matrix, floor + 1, start, l, target);
    }

    public static void main(String[] args) {
        int[][] c = {{1, 4, 7, 11, 15}
                , {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        searchMatrix searchMatrix = new searchMatrix();
        System.out.println(searchMatrix.searchMatrix(c, 5));
    }


}
