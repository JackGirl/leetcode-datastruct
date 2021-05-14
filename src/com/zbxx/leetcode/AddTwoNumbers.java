package com.zbxx.leetcode;

import java.util.Arrays;

public class AddTwoNumbers {
	static AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

	public static void main(String[] args) {
		ListNode l1 = addTwoNumbers.new ListNode(4);
		l1.next = addTwoNumbers.new ListNode(7);
		l1.next.next = addTwoNumbers.new ListNode(9);
		ListNode l2 = addTwoNumbers.new ListNode(5);
		l2.next = addTwoNumbers.new ListNode(3);
		l2.next.next = addTwoNumbers.new ListNode(0);
		ListNode s = addTwoNumbers.addTwoNumbers(l1, l2);
		while (s != null) {
			System.out.print(s.val + "->");
			s = s.next;
		}
	}


	public class ListNode {
		int      val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int outValue = 0, sum, val;
		ListNode newNode = new ListNode(0);
		ListNode next = newNode;
		while (l1 != null || l2 != null) {
			int v1 = l1 == null ? 0 : l1.val;
			int v2 = l2 == null ? 0 : l2.val;
			sum = v1 + v2 + outValue;
			val = sum % 10;
			next.next = new ListNode(val);
			next = next.next;
			outValue = sum / 10;
			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
		}
		//当两个linkList 长度相等最后一个溢出时
		if (outValue > 0) {
			next.next = new ListNode(outValue);
		}
		return newNode.next;
	}


}
