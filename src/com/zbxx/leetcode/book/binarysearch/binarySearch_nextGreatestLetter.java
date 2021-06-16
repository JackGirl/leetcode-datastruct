package com.zbxx.leetcode.book.binarysearch;


/**
 * 寻找比目标大的最小字符串
 */
public class binarySearch_nextGreatestLetter {


    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c', 'd', 'j'}, 'j'));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length - 1;
        int mid;
        if (target >= letters[r]) {
            return letters[0];
        }
        while (l < r) {
            mid = l + (r - l) / 2;
            if (letters[mid] == target) {
                return letters[mid + 1];
            } else if (letters[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return letters[l] > target ? letters[l] : letters[l + 1];
    }


}
