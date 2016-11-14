package com.xyz.abc.sort;

import org.junit.Assert;
import org.junit.Test;

import com.xyz.abc.util.ArrayUtil;

public class BubbleSort {

	public BubbleSort() {
	}

	public void bubbleSort(int[] src) {
		boolean isOrdered = true;

		for (int i = src.length - 1; i > 0; i--) {

			for (int j = 0; j < i; j++) {
				isOrdered = false;
				if (src[j] > src[j + 1]) {
					System.out.println("swap");
					ArrayUtil.swap(src, j, j + 1);
				}
			}
			if (isOrdered)
				break;
		}
	}

	@Test
	public void test() {
		int[] src = new int[] { 13, 5, 1, 0, 7, 8, 11, 4, 2, 2, 1 };
//		src = new int[] { 0, 1, 1, 2, 2, 4, 5, 7, 8, 11, 13 };
		bubbleSort(src);
		Assert.assertArrayEquals(new int[] { 0, 1, 1, 2, 2, 4, 5, 7, 8, 11, 13 }, src);
	}
}
