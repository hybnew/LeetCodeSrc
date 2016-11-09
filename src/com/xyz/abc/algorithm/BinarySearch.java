package com.xyz.abc.algorithm;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearch {

	public BinarySearch() {
	}

	public static int binarySearch(int[] src, int low, int high, int e) {
		int m = -1;

		while (low < high) {
			m = (low + high) / 2;

			if (src[m] > e) {// 当前元素大于待查找元素，则在低半区
				high = m - 1;
			} else if (src[m] < e) {
				low = m + 1;
			} else {
				return m;
			}
		}
		return -1;
	}

	@Test
	public void test() {
		int[] src = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		int pos = binarySearch(src, 0, src.length, 5);
		Assert.assertEquals(4, pos);

		pos = binarySearch(src, 0, src.length, 15);
		Assert.assertEquals(-1, pos);

		pos = binarySearch(src, 0, src.length, -5);
		Assert.assertEquals(-1, pos);
	}

}
