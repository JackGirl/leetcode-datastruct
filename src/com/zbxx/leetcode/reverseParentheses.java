package com.zbxx.leetcode;


import java.util.*;

/**
 * leetcode 1190  翻转每队括号中的字符
 */
public class reverseParentheses {


    public static void main(String[] args) {
        String s = "a(bcdefghijkl(mno)p)q";
        reverseParentheses reverseParentheses = new reverseParentheses();
        System.out.println(reverseParentheses.reverseParentheses(s));
    }


    public String reverseParentheses(String s) {
        char[] sr = s.toCharArray();
        Queue<Character> queue = new LinkedList();
        Stack<Character> stack = new Stack();
        int k = 0;
        for (int i = 0; i < sr.length; i++) {
            if (k == 0 && sr[i] != '(') {
                queue.add(sr[i]);
                continue;
            }
            if (sr[i] == ')') {
                boolean find = false;
                Queue<Character> tq = new LinkedList();
                while (!find) {
                    char t = stack.pop();
                    if (t == '(') {
                        k--;
                        break;
                    }
                    if (k == 1 && t != '(') {
                        queue.add(t);
                    } else if (k > 1 && t != '(') {
                        tq.add(t);
                    }
                }
                if (k > 0) {
                    while (!tq.isEmpty()) {
                        stack.push(tq.poll());
                    }
                }
                continue;
            }
            if (sr[i] == '(') {
                k++;
            }
            stack.push(sr[i]);

        }
        char[] t = new char[queue.size()];
        for (int i = 0; i < t.length; i++) {
            t[i] = queue.poll();
        }
        return new String(t);
    }


}
