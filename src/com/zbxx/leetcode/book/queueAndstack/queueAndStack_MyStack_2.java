package com.zbxx.leetcode.book.queueAndstack;


import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode book 队列和栈 两个队列实现栈
 */
public class queueAndStack_MyStack_2 {

    Deque<Integer> queue1 = new LinkedList<>();

    Deque<Integer> queue2 = new LinkedList<>();

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue1.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        move();
        Integer r = queue1.poll();
        swap();
        return r;
    }

    /**
     * Get the top element.
     */
    public int top() {
        move();
        return queue1.peek();
    }

    public void move() {
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
    }

    public void swap() {
        Deque d = queue1;
        queue1 = queue2;
        queue2 = d;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }

}
