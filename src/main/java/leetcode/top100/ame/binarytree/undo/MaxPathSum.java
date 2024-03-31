package leetcode.top100.ame.binarytree.undo;

import labuladong.binarytree.TreeNode;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/31 20:57
 * @Version 1.0
 */
public class MaxPathSum {


	int maxPathSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		process(root);
		return maxPathSum;
	}

	private int process(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftPathSum = Math.max(process(root.left), 0);
		int rightPathSum = Math.max(process(root.right), 0);
		int pathSum = leftPathSum + rightPathSum + root.val;
		maxPathSum = Math.max(maxPathSum, pathSum);
		return root.val + Math.max(leftPathSum, rightPathSum);
	}

}
