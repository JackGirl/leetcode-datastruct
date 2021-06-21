package com.zbxx.leetcode.book.queueAndstack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


/**
 * leetcode book queueAndStack 转盘锁
 */
public class queueAndStack_bfs_openLock {


    public static void main(String[] args) {
        String[] s = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        String t = "8888";
        System.out.println(openLock(s, t));
    }


    public static int openLock(String[] deadends, String target) {
        Set<String> used = new HashSet<>();
        used.add("0000");
        Set<String> dead = new HashSet<>();
        for (String d : deadends) {
            dead.add(d);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        queue.offer(null);

        int depth = 0;
        while (!queue.isEmpty()) {
            String s = queue.poll();
            if (s == null) {
                depth++;
                if (queue.peek() != null) {
                    queue.offer(null);
                }
            } else if (s.equals(target)) {
                return depth;
            } else if (!dead.contains(s)) {
                for (int i = 0; i < 4; i++) {
                    for (int j = -1; j <= 1; j += 2) {
                        int y = ((s.charAt(i) - '0') + j + 10) % 10;
                        String ns = s.substring(0, i) + ("" + y) + s.substring(i + 1);
                        if (!used.contains(ns)) {
                            used.add(ns);
                            queue.offer(ns);
                        }
                    }
                }
            }
        }
        return -1;
    }


}
