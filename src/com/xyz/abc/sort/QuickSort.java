package com.xyz.abc.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * time complex: worst O(n^2) average O(nlog2^n) space complex: O(nlog2^2)
 * 即函数递归调用的次数*1
 * 
 * Unstable sort
 * @author heyubo
 * 
 */
public class QuickSort {

	// 算法思想：是包含有冒泡的思想，每一次将比基点小的数字放在左边，比基点大的放在右边；
	// 亦有分治的思想：基点左边的数组和基点右边的数组 继续分片

	public QuickSort() {
	}

	/**
	 * 一次划分
	 * 
	 * @param src
	 *            需要排序的数组
	 * @param low
	 *            最小index
	 * @param high
	 *            最大index
	 * @return pivot的最后位置
	 */
	public int partion(int[] src, int low, int high) {
		int pivotIndex = low;
		int pivot = src[pivotIndex];

		while (low < high) {

			//高位扫描
			while (src[high] > pivot && high > low) 
				high--;

			if (low < high) {
				src[pivotIndex] = src[high];
				// src[high] = pivot;
				pivotIndex = high;
				low++;
			}

			//低位扫描
			while (src[low] < pivot && low < high)
				low++;
			if (low < high) {
				src[pivotIndex] = src[low];
				// src[low] = pivot;
				pivotIndex = low;
				high--;
			}
			//一次高位和低位扫描之后再放置支点(待比较的元素)的位置
			src[pivotIndex] = pivot;
		}

		return pivotIndex;
	}

	/**
	 * 快排
	 * @param src
	 * @param low
	 * @param high
	 */
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
