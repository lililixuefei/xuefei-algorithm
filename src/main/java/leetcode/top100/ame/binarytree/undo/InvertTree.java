package leetcode.top100.ame.binarytree.undo;

import labuladong.binarytree.TreeNode;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/31 14:19
 * @Version 1.0
 */
public class InvertTree {

	public TreeNode invertTree(TreeNode root) {
		traverse(root);
		return root;
	}

	// 二叉树遍历函数
	void traverse(TreeNode root) {
		if (root == null) {
			return;
		}

		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;

		traverse(root.left);
		traverse(root.right);
	}


}
