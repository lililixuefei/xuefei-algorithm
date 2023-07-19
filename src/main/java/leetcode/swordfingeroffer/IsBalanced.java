package leetcode.swordfingeroffer;

import labuladong.binarytree.TreeNode;

/**
 * @description: 剑指 Offer 55 - II. 平衡二叉树
 * @author: xuefei
 * @date: 2023/07/19 15:48
 */
public class IsBalanced {

	public boolean isBalanced(TreeNode root) {
		return process(root).isBalanced;
	}

	private Info process(TreeNode node) {
		if (node == null) {
			return new Info(true, 0);
		}

		Info leftInfo = process(node.left);
		Info rightInfo = process(node.right);

		boolean isBalanced = true;
		int height;
		if (!leftInfo.isBalanced || !rightInfo.isBalanced) {
			isBalanced = false;
		}
		if (Math.abs(leftInfo.height - rightInfo.height) > 1) {
			isBalanced = false;
		}
		height = Math.max(leftInfo.height, rightInfo.height) + 1;

		return new Info(isBalanced, height);
	}

	public static class Info {
		boolean isBalanced;
		int height;

		public Info(boolean isBalanced, int height) {
			this.isBalanced = isBalanced;
			this.height = height;
		}
	}

}
