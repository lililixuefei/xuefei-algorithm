package leetcode.top100.ame.binarytree;

import labuladong.binarytree.TreeNode;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/31 14:35
 * @Version 1.0
 */
public class DiameterOfBinaryTree {


	int ans = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		maxDepth(root);
		return ans;
	}

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		ans = Math.max(ans, (leftDepth + rightDepth));
		return Math.max(leftDepth, rightDepth) + 1;
	}

}
