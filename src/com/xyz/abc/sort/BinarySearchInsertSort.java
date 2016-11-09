package com.xyz.abc.sort;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchInsertSort {

	public BinarySearchInsertSort() {
	}

	/**
	 * @author heyubo 插入排序算法</br>
	 *         <p>
	 *         特点:
	 *         </p>
	 *         1. 插入排序是不稳定的排序 <br>
	 *         2.每一次循环不能保证插入到有序列表的元素放置到了最终位置 <br>
	 *         3.time complex : worst O(n^2) best O(n) avg O(n^2) <br>
	 *         4.space complex: O(1)
	 */

	/**
	 * 算法思想：将数组视为有序区域和无序区域，每一次将无序区域的第一个元素插入到有序区域里，知道全部有序
	 * 
	 * @param src
	 *            待排序数组
	 */
	public void binarySearchInsertSort(int[] src) {
		if (src.length <= 1)
			return;
		int i, j, temp;

		temp = src[0];

		for (i = 1; i < src.length; i++) {// 第一个元素为有序，sorting from second
											// element
			j = i - 1;

			int pos = binarySearch(src, 0, j, src[i]);
			temp = src[i];
			src[i] = src[pos];
			src[pos] = temp;
		}
	}

	// @Test
	public void testBSIS() {
		int[] src = new int[] { 13, 5, 1, 0, 7, 8, 11, 4, 2, 2, 1 };
		binarySearchInsertSort(src);
		Assert.assertArrayEquals(new int[] { 0, 1, 1, 2, 2, 4, 5, 7, 8, 11, 13 }, src);

		src = new int[] {};
		binarySearchInsertSort(src);
		Assert.assertArrayEquals(new int[] {}, src);

		src = new int[] { 1 };
		binarySearchInsertSort(src);
		Assert.assertArrayEquals(new int[] { 1 }, src);
	}

	public static int binarySearch(int[] src, int low, int high, int e) {
		int m = -1;

		while (low != high) {
			m = (low + high) / 2;

			if (src[m] > e) {// 当前元素大于待查找元素，则在低半区
				high = m - 1;
			} else if (src[m] < e) {// 高半区
				low = m + 1;
			} else {
				break;
			}
		}
		return m + 1;
	}

	@Test
	public void test() {
		int[] src = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 100 };
		int pos = binarySearch(src, 0, src.length, 5);
		Assert.assertEquals(5, pos);

		pos = binarySearch(src, 0, src.length, 15);
		Assert.assertEquals(src.length, pos);

		pos = binarySearch(src, 0, src.length, -5);
		Assert.assertEquals(0, pos);

		pos = binarySearch(src, 0, src.length, 9);
		Assert.assertEquals(0, pos);
	}

}
