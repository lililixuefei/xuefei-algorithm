package leetcode.basic.dfs;

import leetcode.basic.binarytree.TreeNode;

/**
 * @description: 二叉树的最小深度
 * @author: xuefei
 * @date: 2023/03/29 22:32
 */
public class MinDepth {

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		int minDepth = Integer.MAX_VALUE;
		if (root.left != null) {
			minDepth = Math.min(minDepth(root.left), minDepth);
		}
		if (root.right != null) {
			minDepth = Math.min(minDepth(root.right), minDepth);
		}
		return minDepth + 1;
	}

}
