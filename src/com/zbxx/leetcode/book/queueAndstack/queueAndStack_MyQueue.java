package com.zbxx.leetcode.book.queueAndstack;

import java.util.Deque;
import java.util.LinkedList;


/**
 * leetcode book 队列和栈 两个队列实现栈
 */
public class queueAndStack_MyQueue {

    Deque<Integer> stack1 = new LinkedList<>();
    Deque<Integer> stack2 = new LinkedList<>();


    /**
     * Initialize your data structure here.
     */
    public queueAndStack_MyQueue() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (stack2.isEmpty()) {
            transfer();
        }
        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (stack2.isEmpty()) {
            transfer();
        }
        return stack2.peek();
    }

    public void transfer() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
