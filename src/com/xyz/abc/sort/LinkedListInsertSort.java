package com.xyz.abc.sort;

import org.junit.Test;

import com.xyz.abc.datastruct.Node;

public class LinkedListInsertSort {

	public LinkedListInsertSort() {
	}

	/**
	 * 带头节点，简单插入排序<br>
	 * 简单插入分为有序部分和无序部分；
	 * 
	 * @param head
	 */
	public void insertSort(Node head) {
		if (head != null && head.next != null) {
			Node p0 = head.next;
			Node p0pre = head;
			Node disorderedEnd = head.next;
			Node orderedFirst = p0.next;

			while (orderedFirst != null) {// 外层循环，无序部分
				p0pre = head;
				p0 = head.next;// 内层循环每次从第一个节点开始
				while (p0 != null && p0 != disorderedEnd.next) {// 内层循环，有序部分
					if (orderedFirst.val < p0.val) {// 从第一个节点向后遍历，直至有序部分遍历完毕
						// 或者找到一个比p1.val大的节点p0,则将p1插入到p0之前或什么都不做；
						disorderedEnd.next = orderedFirst.next;
						p0pre.next = orderedFirst;
						orderedFirst.next = p0;
						break;
					}
					p0pre = p0;
					p0 = p0.next;
				}
				disorderedEnd = orderedFirst;
				orderedFirst = orderedFirst.next;
			}
		}
	}

	@Test
	public void test() {
		Node head = new Node();

		Node p, p1 = head;
		for (int i = 10; i > 0; i--) {
			p = new Node(i);
			p1.next = p;
			p1 = p1.next;
		}
		print(head);

		insertSort(head);
		print(head);
		insertSort(head);
		print(head);
	}

	public void print(Node head) {
		Node p = head.next;

		System.out.println();
		while (p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
		System.out.println();
	}
}
