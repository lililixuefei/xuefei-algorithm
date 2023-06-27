package leetcode.basic.dfs;

import xuefei.labuladong.binarytree.TreeNode;

/**
 * @description: 左叶子之和
 * @author: xuefei
 * @date: 2023/03/30 22:34
 */
public class SumOfLeftLeaves {


	public int sumOfLeftLeaves(TreeNode root) {
		return root != null ? dfs(root) : 0;
	}

	public int dfs(TreeNode node) {
		int ans = 0;
		if (node.left != null) {
			ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
		}
		if (node.right != null && !isLeafNode(node.right)) {
			ans += dfs(node.right);
		}
		return ans;
	}

	public boolean isLeafNode(TreeNode node) {
		return node.left == null && node.right == null;
	}


	int sum = 0;

	public int sumOfLeftLeaves_me(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left != null) {
			sum += isLeafNode(root.left) ? root.left.val : 0;
		}
		sumOfLeftLeaves_me(root.left);
		sumOfLeftLeaves_me(root.right);
		return sum;
	}


}
