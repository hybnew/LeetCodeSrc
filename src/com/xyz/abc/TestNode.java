package com.xyz.abc;

public class TestNode {

	static class Node {
		int val;
		Node next;
	}

	public static void main(String[] args) {
		Node head = new Node();
		head.next = new Node();
		head.next.val = 1;
		head.next.next = new Node();
		head.next.next.val = 2;
		head.next.next.next = new Node();
		head.next.next.next.val = 3;

		head = revert(head);

		print(head);
	}

	public static Node revert(Node head) {

		Node p, pNext;

		if (head != null && head.next != null) {

			p = head.next;
			head.next = null;

			while (null != p) {
				pNext = p.next;
				p.next = head.next;
				head.next = p;

				p = pNext;
			}
		}

		return head;
	}

	public static void print(Node head) {

		Node p = head;
		while ((p = p.next) != null) {
			System.out.println(p.val + " ");
		}
	}

}
