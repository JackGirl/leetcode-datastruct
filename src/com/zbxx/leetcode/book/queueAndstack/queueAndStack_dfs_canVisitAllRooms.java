package com.zbxx.leetcode.book.queueAndstack;


import java.util.*;

/**
 * leetcode book 栈和队列  钥匙和房间
 */
public class queueAndStack_dfs_canVisitAllRooms {

    public static void main(String[] args) {

    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Deque<List<Integer>> deque = new LinkedList();
        deque.add(rooms.get(0));
        while (!deque.isEmpty()) {
            List<Integer> keys = deque.poll();
            if (!keys.isEmpty()) {
                for (Integer key : keys) {
                    if (!visited.contains(key)) {
                        deque.offer(rooms.get(key));
                        visited.add(key);
                    }
                }
            }
        }
        return visited.size() == rooms.size();
    }


}
