package com.zbxx.leetcode.book.list;


/**
 * leetcode book list 实现链表
 */
public class list_MyLinkedList {

    int size;

    ListNode head;

    ListNode last;

    static class ListNode {

        public int val;

        public ListNode prev;

        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

    }

    /**
     * Initialize your data structure here.
     */
    public list_MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode node = getByIndex(index);
        return node == null ? -1 : node.val;
    }

    public ListNode getByIndex(int index) {
        ListNode node = head;
        int idx = 0;
        while (node != null) {
            if (idx == index) {
                return node;
            }
            node = node.next;
            idx++;

        }
        return node;
    }


    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
            last = head;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }

        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
            last = head;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }

        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index <= size) {
            ListNode node = new ListNode(val);
            if (head == null) {
                head = node;
                last = node;
            } else if (index <= 0) {
                head.prev = node;
                node.next = head;
                head = node;
            } else {
                ListNode N = getByIndex(index);
                if (N == null) {
                    last.next = node;
                    node.prev = last;
                    last = node;
                } else {
                    node.prev = N.prev;
                    if (node.prev != null) {
                        node.prev.next = node;
                    }
                    node.next = N;
                    N.prev = node;
                }
            }
        }
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        ListNode node = getByIndex(index);
        if (node != null) {
            if (node == head) {
                if (node == last) {
                    last = null;
                    head = null;
                } else {
                    head = head.next;
                    head.prev = null;
                }
            } else {
                if (node == last) {
                    last = last.prev;
                    last.next = null;
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
            }
        }
    }


}
