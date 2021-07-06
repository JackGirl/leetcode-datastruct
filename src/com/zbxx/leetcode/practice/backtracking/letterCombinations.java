package com.zbxx.leetcode.practice.backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 中级算法 电话号码的字母组合
 */
public class letterCombinations {


    char[][] mr = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };


    public List<String> letterCombinations(String digits) {
        List<String> rs = new ArrayList<>();
        if (digits.length() == 0) {
            return rs;
        }
        StringBuilder builder = new StringBuilder();
        char[] sr = digits.toCharArray();
        backtracking(rs, builder, sr, 0);
        return rs;
    }

    public void backtracking(List<String> rs, StringBuilder builder, char[] sr, int idx) {
        int mrIdx = sr[idx] - '0';
        for (int i = 0; i < mr[mrIdx - 2].length; i++) {
            builder.append(mr[mrIdx - 2][i]);
            if (builder.length() == sr.length) {
                rs.add(builder.toString());
            }
            if (builder.length() < sr.length) {
                backtracking(rs, builder, sr, idx + 1);
            }
            builder.deleteCharAt(builder.length() - 1);
        }
    }


    public static void main(String[] args) {
        letterCombinations letterCombinations = new letterCombinations();
        System.out.println(letterCombinations.letterCombinations("23"));
    }


}
