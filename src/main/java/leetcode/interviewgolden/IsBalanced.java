package leetcode.interviewgolden;

import leetcode.basic.binarytree.TreeNode;

/**
 * @description: 检查平衡性
 * @author: xuefei
 * @date: 2023/03/07 23:31
 */
public class IsBalanced {
	private boolean isBalanced = true;

	public boolean isBalanced(TreeNode root) {
		maxDepth(root);
		return isBalanced;
	}

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int lDepth = maxDepth(root.left);
		int rDepth = maxDepth(root.right);
		if (Math.abs(lDepth - rDepth) > 1) {
			isBalanced = false;
		}
		return Math.max(lDepth, rDepth) + 1;
	}


}
