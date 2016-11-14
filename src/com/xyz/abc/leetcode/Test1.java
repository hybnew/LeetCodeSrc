package com.xyz.abc.leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

public class Test1 {

	public Test1() {
	}

	@Test
	public void test_canConstruct() {
		assertTrue(canConstruct("a", "ab"));
		assertTrue(!canConstruct("aa", "ab"));
		assertTrue(canConstruct("aa", "baab"));
		assertTrue(!canConstruct("aa", "bccb"));
	}

	public boolean canConstruct(String ransomNote, String magazine) {
		int[] letters = new int[26];

		char str;
		for (int i = 0; i < ransomNote.length(); i++) {
			str = ransomNote.charAt(i);
			int iStr = str - 'a';
			letters[iStr]++;
		}
		for (int i = 0; i < magazine.length(); i++) {
			str = magazine.charAt(i);
			int iStr = str - 'a';
			letters[iStr]--;
		}

		for (int i = 0; i < letters.length; i++) {
			if (letters[i] > 0)
				return false;
		}
		return true;
	}

	public int[] intersection(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int[] sec = new int[Math.max(len1, len2)];
		for (int i = 0; i < nums1.length; i++) {


		}
		return sec;
	}
}
