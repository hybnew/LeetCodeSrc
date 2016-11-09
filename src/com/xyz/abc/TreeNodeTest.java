package com.xyz.abc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class TreeNodeTest {

	class TreeNode {
		TreeNode left, right;
		int val;

		public TreeNode() {
		}
	}

	public int sumOfLeftLeaves(TreeNode root) {
		int sum = 0;
		
		if (root == null || (root.left == null && root.right == null))
			return 0;

		Stack<TreeNode> s = new Stack<TreeNodeTest.TreeNode>();
		TreeNode  p = root;
		s.push(p);
		
		while(!s.empty()){
			p = s.pop();
			
			if (p.left != null && (p.left.left == null && p.left.right == null))
				sum += p.left.val;
			if (p.right != null)
				s.push(p.right);
			if (p.left != null)
				s.push(p.left);
		}
		return sum;
	}
	public int sumOfLeftLeaves1(TreeNode root) {
		int sum = 0;
		// 1. the ordinal of node's left son in an array is j = 2* i;
		// 2.

		if (root == null || (root.left == null && root.right == null))
			return 0;
		Queue<TreeNode> q = new LinkedList<TreeNodeTest.TreeNode>();
		TreeNode p = root;
		q.offer(p);

		while (!q.isEmpty()) {
			p = q.remove();

			if (p.left != null && (p.left.left == null && p.left.right == null))
				sum += p.left.val;
			if (p.left != null)
				q.offer(p.left);
			if (p.right != null)
				q.offer(p.right);
		}
		return sum;
	}

	public int sumOfLeftLeaves0(TreeNode root) {
		int sum = 0;

		TreeNode p = root, node;
		Boolean isLeftLeaf;
		Stack<TreeNode> s = new Stack<TreeNodeTest.TreeNode>();
		Stack<Boolean> sb = new Stack<Boolean>();

		if (null != p) {
			s.push(p);
			if (p.left != null || p.right != null) {
				sb.push(Boolean.FALSE);
			} else {
				sb.push(Boolean.TRUE);
			}

			while (!s.empty()) {// preorder
				p = s.pop();
				isLeftLeaf = sb.pop();
				if (isLeftLeaf && p.left == null && p.right == null) {
					sum += p.val;
				}

				//
				node = p.right;
				if (null != node) {
					s.push(node);
					if (node.left != null && node.right != null) {
						sb.push(Boolean.FALSE);
					} else {
						sb.push(Boolean.TRUE);
					}
				}

				node = p.left;
				if (null != node) {
					s.push(node);
				}
			}
		}
		return sum;
	}

	@Test
	public void test() {
		TreeNode root = new TreeNode();
		root.val = 1;
		Assert.assertEquals(0, sumOfLeftLeaves(root));
		root.left = new TreeNode();
		root.right = new TreeNode();
		root.left.val = 2;
		root.right.left = new TreeNode();
		root.right.left.val = 3;
		Assert.assertEquals(5, sumOfLeftLeaves(root));
	}
}
