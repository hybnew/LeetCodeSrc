package com.xyz.abc.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * time complex: O(nlog2n)<br>
 * space complex: O(1);
 * Unstable sort
 * @author heyubo
 *
 */
public class ShellSort {

	public ShellSort() {
	}

	public void shellSort(int[] src) {
		int inc = 9;
		int len = src.length;
		inc = inc > len ? (len % 2 == 0 ? len - 1 : len) : inc;

		for (int i = inc; i >= 1; i -= 2) {
			for (int j = 0; j < i; j++) {
				insertSort(src, j, i);
			}
		}
	}

	public void insertSort(int[] src, int start, int increment) {
		if (src.length <= 1)
			return;
		int i, j, temp;
		temp = src[0];

		for (i = start + 1; i < src.length; i += increment) {// 第一个元素为有序，sorting
																// from
			// second
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
	public void test() {
		int[] src = new int[] { 3, 1, 9, 7, 5 };
		shellSort(src);
		Assert.assertArrayEquals(new int[] { 1, 3, 5, 7, 9 }, src);

		src = new int[] { 1, 0, 1, 0, 3, 1, 9, 7, 5 };
		shellSort(src);
		Assert.assertArrayEquals(new int[] { 0, 0, 1, 1, 1, 3, 5, 7, 9 }, src);

		src = new int[] { 110, 11, 9, 1, 0, 1, 0, 3, 1, 9, 7, 5 };
		shellSort(src);
		Assert.assertArrayEquals(new int[] { 0, 0, 1, 1, 1, 3, 5, 7, 9, 9, 11, 110 }, src);
	}
}
