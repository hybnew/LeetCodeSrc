package com.xyz.abc.sort;

import org.junit.Assert;
import org.junit.Test;

public class MergeSort {

	public MergeSort() {
	}

	/**
	 * 两个有序列表的合并
	 * 
	 * @param arr1
	 * @param arr2
	 */
	public void merge(int[] arr, int s, int m, int n) {
		int i = s, j = m + 1, k;
		int[] temp = new int[arr.length];

		for (k = 0; i <= m && j <= n; k++) {
			if (arr[i] <= arr[j])
				temp[k] = arr[i++];
			else
				temp[k] = arr[j++];
		}

		while (i <= m)
			temp[k++] = arr[i++];
		while (j <= n)
			temp[k++] = arr[j++];

		System.arraycopy(temp, 0, arr, s, n - s + 1);
	}

	public void mergeSort(int[] arr, int start, int end) {
		int m = (start + end) / 2;

		if (start >= end)
			return;
		mergeSort(arr, start, m);
		mergeSort(arr, m + 1, end);
		merge(arr, start, m, end);
	}

	@Test
	public void test() {

		int[] arr = new int[] { 2, 1, 4, 6, 5, 1000000, 222, 222, 111, 222, 111, 122, 44 };
		mergeSort(arr, 0, arr.length - 1);
		Assert.assertArrayEquals(new int[] { 1, 2, 4, 5, 6, 44, 111, 111, 122, 222, 222, 222, 1000000 }, arr);
	}
}
