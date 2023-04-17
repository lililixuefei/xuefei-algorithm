package leetcode.basic.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 求根节点到叶节点数字之和
 * @author: xuefei
 * @date: 2023/04/17 23:49
 */
public class SumNumbers {

	public int sumNumbers_dfs(TreeNode root) {
		return dfs(root, 0);
	}

	public int dfs(TreeNode root, int prevSum) {
		if (root == null) {
			return 0;
		}
		int sum = prevSum * 10 + root.val;
		if (root.left == null && root.right == null) {
			return sum;
		} else {
			return dfs(root.left, sum) + dfs(root.right, sum);
		}
	}


	public int sumNumbers_bfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int sum = 0;
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		Queue<Integer> numQueue = new LinkedList<>();
		nodeQueue.offer(root);
		numQueue.offer(root.val);
		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.poll();
			int num = numQueue.poll();
			TreeNode left = node.left;
			TreeNode right = node.right;
			if (left == null && right == null) {
				sum += num;
			} else {
				if (left != null) {
					nodeQueue.offer(left);
					numQueue.offer(num * 10 + left.val);
				}
				if (right != null) {
					nodeQueue.offer(right);
					numQueue.offer(num * 10 + right.val);
				}
			}
		}
		return sum;
	}


}
