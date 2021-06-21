package com.zbxx.leetcode.book.queueAndstack;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * leetcode book queueAndStack 是否合法括号
 */
public class QueueAndStack_isValid {


    public static void main(String[] args) {
        System.out.println(isValid("([])"));
    }

    public static boolean isValid(String s) {
        char[] sr = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < sr.length; i++) {
            char t = sr[i];
            if (t == '(') {
                stack.push(')');
            } else if (t == '[') {
                stack.push(']');
            } else if (t == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char tr = stack.poll();
                if (tr != t) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}
