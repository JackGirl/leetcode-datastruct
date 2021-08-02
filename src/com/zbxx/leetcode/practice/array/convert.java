package com.zbxx.leetcode.practice.array;


/**
 * N字形转换
 */
public class convert {


    public static void main(String args[]) {
        String s = "Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.";
        System.out.println(convert(s, 3));
    }

    public static String convert(String s, int numRows) {
        if (s.length() < numRows) {
            return s;
        }
        if (numRows == 1) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] sr = s.toCharArray();
        int q = s.length();
        char[][] t = new char[numRows][q];
        int x = 0;
        int y = 0;
        int index = 0;
        t[0][0] = sr[index++];
        while (true) {
            if (index == sr.length) {
                break;
            }
            while (index < sr.length && x < numRows - 2) {
                t[++x][y] = sr[index++];
            }
            int i = numRows;
            x++;
            while (index < sr.length && i > 0) {
                t[x--][y++] = sr[index++];
                i--;
            }
            y--;
            x = 0;
        }
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if (t[i][j] != 0) {
                    stringBuilder.append(t[i][j]);
                }
            }
        }
        return stringBuilder.toString();
    }


}
