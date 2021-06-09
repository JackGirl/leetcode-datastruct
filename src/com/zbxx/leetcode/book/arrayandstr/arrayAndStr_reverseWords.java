package com.zbxx.leetcode.book.arrayandstr;


import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 学习> 数组和字符串 翻转字符串里的单词
 * <p>
 * 还可以使用指针 和一个临时变量存储不是空格的字符 和找到空格的上一个字符  直接入dequeue 然后反向 输出
 */
public class arrayAndStr_reverseWords {


    public static void main(String[] args) {
        arrayAndStr_reverseWords reverseWords = new arrayAndStr_reverseWords();
        String s = "the sky is blue";
        System.out.println(reverseWords.reverseWords(s));
    }

    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        char[] sr = s.toCharArray();
        Deque deque = new LinkedList();
        for (int i = sr.length - 1; i >= 0; i--) {
            if (sr[i] == ' ') {
                if (!deque.isEmpty()) {
                    builder.append(" ");
                }
                while (!deque.isEmpty()) {
                    builder.append(deque.pollFirst());
                }
                continue;
            }
            deque.addFirst(sr[i]);
        }
        if (!deque.isEmpty()) {
            builder.append(" ");
            while (!deque.isEmpty()) {
                builder.append(deque.pollFirst());
            }
        }
        return builder.substring(1);
    }


}
