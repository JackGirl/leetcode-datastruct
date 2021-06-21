package com.zbxx.leetcode.book.queueAndstack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class queueAndStack_MinStack {

    List<Integer> data;

    LinkedList<Integer> sort;

    /**
     * initialize your data structure here.
     */
    public queueAndStack_MinStack() {
        data = new ArrayList<>();
        sort = new LinkedList<>();
    }

    public void push(int val) {
        data.add(data.size(), val);
        int index = 0;
        for (Integer integer : sort) {
            if (val < integer) {
                index++;
            }
        }
        sort.add(index, val);
    }

    public void pop() {
        Integer t = data.remove(data.size() - 1);
        sort.remove(t);
    }

    public int top() {
        return data.get(data.size() - 1);
    }

    public int getMin() {
        return sort.getLast();
    }


}
