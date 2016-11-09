package com.xyz.abc.sort;

import org.junit.Assert;
import org.junit.Test;

public class QuickSort {

	// 算法思想：是包含有冒泡的思想，每一次将比基点小的数字放在左边，比基点大的放在右边；
	// 亦有分治的思想：基点左边的数组和基点右边的数组 继续分片

	public QuickSort() {
	}

	public int partion(int[] src, int low, int high) {
		int pivotIndex = low;
		int pivot = src[pivotIndex];

		while (low < high) {

			while (src[high] > pivot && high > low) {
				high--;
			}
			if (low < high) {

				src[pivotIndex] = src[high];
				// src[high] = pivot;
				pivotIndex = high;
				low++;
			}

			while (src[low] < pivot && low < high)
				low++;
			if (low < high) {
				src[pivotIndex] = src[low];
				// src[low] = pivot;
				pivotIndex = low;
				high--;
			}
			src[pivotIndex] = pivot;
		}

		return pivotIndex;
	}

	public void quickSort(int[] src, int low, int high) {

		if (low >= high || high < 0)
			return;
		int pi = partion(src, low, high);
		if (low < pi - 1)
			quickSort(src, low, pi - 1);
		if (pi + 1 < high)
			quickSort(src, pi + 1, high);
	}

	@Test
	public void testQS() {
		int[] src = new int[] { 13, 5, 1, 0, 7, 8, 11, 4, 2, 2, 1 };
		quickSort(src, 0, src.length - 1);
		Assert.assertArrayEquals(new int[] { 0, 1, 1, 2, 2, 4, 5, 7, 8, 11, 13 }, src);

		src = new int[] {};
		quickSort(src, 0, src.length - 1);
		Assert.assertArrayEquals(new int[] {}, src);

		src = new int[] { 1 };
		quickSort(src, 0, src.length - 1);
		Assert.assertArrayEquals(new int[] { 1 }, src);
	}
}
