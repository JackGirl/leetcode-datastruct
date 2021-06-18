package com.zbxx.leetcode.book.queueAndstack;

public class queueAndStack_circleQueue {

    int size = 0;

    int head = -1;

    int tail = -1;

    int[] data;


    public queueAndStack_circleQueue(int k) {
        data = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            head = 0;
            tail = 0;
            data[tail] = value;
        } else {
            tail++;
            if (tail == data.length) {
                tail = 0;
            }
            data[tail] = value;
        }
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            data[head] = 0;
            head++;
            if (head == data.length) {
                head = 0;
            }
        }
        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : data[head];
    }

    public int Rear() {
        return isEmpty() ? -1 : data[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public static void main(String[] args) {
        queueAndStack_circleQueue queue = new queueAndStack_circleQueue(3);
        System.out.println(queue.enQueue(1));
        System.out.println(queue.enQueue(2));
        System.out.println(queue.enQueue(3));
        System.out.println(queue.enQueue(4));
    }

}
