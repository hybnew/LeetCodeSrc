/**
 * 
 */
package com.xyz.abc.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author heyubo 插入排序算法</br>
 *         <p>
 *         特点:
 *         </p>
 *         1. 插入排序是稳定的排序 <br>
 *         2.每一次循环不能保证插入到有序列表的元素放置到了最终位置 <br>
 *         3.time complex : worst O(n^2) best O(n) avg O(n^2) <br>
 *         4.space complex: O(1)
 */
public class InsertSort {

	public InsertSort() {
	}

	/**
	 * 算法思想：将数组视为有序区域和无序区域，每一次将无序区域的第一个元素插入到有序区域里，知道全部有序
	 * 
	 * @param src
	 *            待排序数组
	 */
	public void insertSort(int[] src) {
		if (src.length <= 1)
			return;
		int i, j, temp;

		temp = src[0];

		for (i = 1; i < src.length; i++) {// 第一个元素为有序，sorting from second
											// element
			j = i - 1;
			if (j >= 0) {
				temp = src[i];
				while (j >= 0 && src[j] > temp) {// 直到找到比src[i]小的
					src[j + 1] = src[j];
					j--;
				}
				src[j + 1] = temp;
			}
		}
	}

	@Test
	public void testIS() {
		int[] src = new int[] { 13, 5, 1, 0, 7, 8, 11, 4, 2, 2, 1 };
		insertSort(src);
		Assert.assertArrayEquals(new int[] { 0, 1, 1, 2, 2, 4, 5, 7, 8, 11, 13 }, src);

		src = new int[] {};
		insertSort(src);
		Assert.assertArrayEquals(new int[] {}, src);

		src = new int[] { 1 };
		insertSort(src);
		Assert.assertArrayEquals(new int[] { 1 }, src);
	}
}
