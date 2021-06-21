package com.zbxx.leetcode.book.queueAndstack;

import java.util.Deque;
import java.util.LinkedList;

public class queueAndStack_decodeString {


    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }


    public static String decodeString(String s) {
        Deque<Character> deque = new LinkedList<>();
        char[] sr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Deque<Integer> numStack = new LinkedList<>();
        int preNum = 0;
        for (char c : sr) {
            if (Character.isDigit(c)) {
                preNum = preNum * 10 + ((c - '0' + 10) % 10);
                continue;
            } else if (c == '[') {
                numStack.push(preNum);
                preNum = 0;
                deque.offer(c);
            } else if (c == ']') {
                builder.delete(0, builder.length());
                while (!deque.isEmpty()) {
                    char t = deque.pollLast();
                    if (t == '[') {
                        break;
                    }
                    builder.insert(0, t);
                }
                int num = numStack.pop();
                String str = builder.toString();
                for (int i = 1; i < num; i++) {
                    builder.append(str);
                }
                char[] arr = builder.toString().toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    deque.offer(arr[i]);
                }
            } else {
                deque.offer(c);
            }
        }
        while (!deque.isEmpty()) {
            sb.append(deque.poll());
        }
        return sb.toString();
    }


}
