package leetcode.swordfingeroffer;

import labuladong.binarytree.TreeNode;

import java.util.*;

/**
 * @description: 剑指 Offer 32 - I. 从上到下打印二叉树
 * @author: xuefei
 * @date: 2023/07/18 23:23
 */
public class LevelOrder {


	public List<List<Integer>> levelOrder3(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		// 为 true 时向右，false 时向左
		boolean flag = true;
		// while 循环控制从上向下一层层遍历
		while (!q.isEmpty()) {
			int sz = q.size();
			// 记录这一层的节点值
			LinkedList<Integer> level = new LinkedList<>();
			// for 循环控制每一层从左向右遍历
			for (int i = 0; i < sz; i++) {
				TreeNode cur = q.poll();
				// 实现 z 字形遍历
				if (flag) {
					level.addLast(cur.val);
				} else {
					level.addFirst(cur.val);
				}
				if (cur.left != null) {
					q.offer(cur.left);
				}
				if (cur.right != null) {
					q.offer(cur.right);
				}
			}
			// 切换方向
			flag = !flag;
			res.add(level);
		}
		return res;
	}


	public List<List<Integer>> levelOrder2(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<List<Integer>> ans = new ArrayList<>();
		Deque<TreeNode> deque = new LinkedList<>();
		deque.add(root);
		while (!deque.isEmpty()) {
			int size = deque.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode treeNode = deque.poll();
				list.add(treeNode.val);
				if (treeNode.left != null) {
					deque.add(treeNode.left);
				}
				if (treeNode.right != null) {
					deque.add(treeNode.right);
				}
			}
			ans.add(list);
		}
		return ans;
	}


	public int[] levelOrder(TreeNode root) {
		if (root == null) {
			return new int[0];
		}
		List<Integer> ans = new ArrayList<>();
		Deque<TreeNode> deque = new LinkedList<>();
		deque.add(root);
		while (!deque.isEmpty()) {
			TreeNode treeNode = deque.poll();
			ans.add(treeNode.val);
			if (treeNode.left != null) {
				deque.add(treeNode.left);
			}
			if (treeNode.right != null) {
				deque.add(treeNode.right);
			}
		}
		return ans.stream().mapToInt(Integer::intValue).toArray();
	}


}
