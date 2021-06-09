package com.zbxx.leetcode.book.arrayandstr;


import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 数组和字符串 翻转字符
 */
public class arrayAndStr_reverseWords2 {


    public static void main(String[] args) {
        System.out.println();
    }

    public static String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        Deque<Character> stack = new LinkedList();
        char[] sr = s.toCharArray();
        for (int i = 0; i < sr.length; i++) {
            if (sr[i] == ' ') {
                while (!stack.isEmpty()) {
                    stringBuilder.append(stack.pollLast());
                }
                stringBuilder.append(" ");
            } else {
                stack.addLast(sr[i]);
            }
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pollLast());
        }
        return stringBuilder.toString();
    }


}
