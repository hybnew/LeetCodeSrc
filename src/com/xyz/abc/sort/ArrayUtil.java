package com.xyz.abc.sort;

import org.junit.Assert;
import org.junit.Test;

public class ArrayUtil {

	public ArrayUtil() {
	}

	public static void swap(int[] src, int i, int j) {
		int temp = src[i];
		src[i] = src[j];
		src[j] = temp;
	}

	@Test
	public void test() {
		int[] a = new int[] { 1, 2 };
		swap(a, 0, 1);
		Assert.assertArrayEquals(new int[]{2,1}, a);
	}
}
