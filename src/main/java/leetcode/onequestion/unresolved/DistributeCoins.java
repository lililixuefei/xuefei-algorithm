package leetcode.onequestion.unresolved;

import labuladong.binarytree.TreeNode;

/**
 * @description: 在二叉树中分配硬币
 * @author: xuefei
 * @date: 2023/07/14 21:37
 */
public class DistributeCoins {

	int move;

	public int distributeCoins(TreeNode root) {
		dfs(root);
		return move;
	}

	private int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftMove = 0;
		int rightMove = 0;

		if (root.left != null) {
			leftMove = dfs(root.left);
		}
		if (root.right != null) {
			rightMove = dfs(root.right);
		}

		move += Math.abs(leftMove) + Math.abs(rightMove);
		return leftMove + rightMove + root.val - 1;

	}

}
