package com.zbxx.leetcode.practice.array;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 1910 删除一个字符串中所有出现的给定子字符串
 */
public class removeOccurrences {

    public String removeOccurrences(String s, String part) {
        int index = s.indexOf(part);
        if (index != -1) {
            s = s.replaceFirst(part, "");
            return removeOccurrences(s, part);
        }
        return s;
    }

    public static void main(String[] args) {
        removeOccurrences r = new removeOccurrences();
        System.out.println(r.removeOccurrences("axxxxyyyyb", "xy"));
    }

}
