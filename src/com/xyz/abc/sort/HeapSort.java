package com.xyz.abc.sort;

import org.junit.Assert;
import org.junit.Test;

import com.xyz.abc.util.ArrayUtil;
import com.xyz.abc.util.Profiler;

/**
 * 堆排序的两大核心：先将数组调整为大顶堆或小顶堆<br>
 * 再取堆顶元素，与最后一个元素交换；然后调整交换后的堆顶元素<br>
 * 注意：为了使用静态数组的树结构，从第2个位置开始存储,that is index >= 1
 * 
 * @author heyubo
 * 
 */
public class HeapSort {

	public HeapSort() {
	}

	/**
	 * 一次shift则完成了对src[]规定区间的第一个元素的调整
	 * 
	 * @param src
	 * @param low
	 * @param high
	 */
	public void shift(int src[], int pos, int len) {
		int sonIndex = pos * 2;// left son index

		while (pos < len / 2) {
			if (src[sonIndex] < src[sonIndex + 1]) {
				sonIndex++;
			}

			if (src[pos] < src[sonIndex]) {
				ArrayUtil.swap(src, sonIndex, pos);
				pos = sonIndex;
				sonIndex = pos * 2;
			} else
				break;
		}
	}

	public void heapSort(int src[]) {
		int len = src.length;

		// 首先对数组做调整，使之成为大顶堆
		for (int i = len / 2; i >= 1; i--) {// 只需对非叶子节点做调整
			shift(src, i, src.length);
		}

		// 然后交换栈顶元素与最后一个元素并重新调整一次,直到全部有序，即堆为空
		for (int j = len - 1; j >= 2; j--) {
			ArrayUtil.swap(src, 1, j);
			shift(src, 1, j);
		}
	}

	public int[] topKey(int[] src, int k) {
		int len = src.length;

		// 首先对数组做调整，使之成为大顶堆
		for (int i = len / 2; i >= 1; i--) {// 只需对非叶子节点做调整
			shift(src, i, src.length);
		}

		// 然后交换栈顶元素与最后一个元素并重新调整一次,直到全部有序，即堆为空
		for (int j = len - 1; j >= len - k - 1; j--) {
			ArrayUtil.swap(src, 1, j);
			shift(src, 1, j);
		}

		int[] rs = new int[k];
		System.arraycopy(src, len - k, rs, 0, k);
		return rs;
	}

	@Test
	public void test() {
		int[] a = new int[] { 0, 6, 7, 9, 3, 1, 2, 8, 7 };
		shift(a, 1, a.length);
		Assert.assertArrayEquals(new int[] { 0, 9, 7, 8, 3, 1, 2, 6, 7 }, a);

		heapSort(a);
		Assert.assertArrayEquals(new int[] { 0, 1, 2, 3, 6, 7, 7, 8, 9 }, a);

		final int MAX = 1000000;
		int[] arr = new int[MAX];
		for (int i = 1; i < MAX; i++) {
			arr[i] = MAX - i;
		}

		Profiler.begin(null);
		// top key
		int[] rs = topKey(arr, 10);
		Profiler.end(null);
		Assert.assertArrayEquals(new int[] { 999990,999991, 999992, 999993, 999994, 999995, 999996,999997, 999998, 999999 }, rs);
		heapSort(arr);
		Assert.assertEquals(MAX - 1, arr[MAX - 1]);

	}
}