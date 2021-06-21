package com.zbxx.leetcode.book.queueAndstack;


import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode book queueAndStack 逆波兰表达式
 */
public class queueAndStack_evalRPN {

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }

    public static int evalRPN(String[] tokens) {
        Deque<String> stack = new LinkedList<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                Integer n1 = Integer.valueOf(stack.pop());
                Integer n2 = Integer.valueOf(stack.pop());
                stack.push((String.valueOf(n2 + n1)));
            } else if (token.equals("-")) {
                Integer n1 = Integer.valueOf(stack.pop());
                Integer n2 = Integer.valueOf(stack.pop());
                stack.push((String.valueOf(n2 - n1)));
            } else if (token.equals("/")) {
                Integer n1 = Integer.valueOf(stack.pop());
                Integer n2 = Integer.valueOf(stack.pop());
                stack.push((String.valueOf(n2 / n1)));
            } else if (token.equals("*")) {
                Integer n1 = Integer.valueOf(stack.pop());
                Integer n2 = Integer.valueOf(stack.pop());
                stack.push((String.valueOf(n1 * n2)));
            } else {
                stack.push(token);
            }

        }
        return Integer.valueOf(stack.pop());
    }

}
