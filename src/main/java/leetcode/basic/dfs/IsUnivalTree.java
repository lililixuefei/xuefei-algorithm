package leetcode.basic.dfs;

import xuefei.labuladong.binarytree.TreeNode;

/**
 * @description: 单值二叉树
 * @author: xuefei
 * @date: 2023/04/22 19:03
 */
public class IsUnivalTree {

	private int value;

	public boolean isUnivalTree(TreeNode root) {
		if (root == null){
			return true;
		}
		value = root.val;

		return traverse(root);

	}

	private boolean traverse(TreeNode root) {
		if (root == null){
			return true;
		}
		if (root.val != value){
			return false;
		}
		return traverse(root.left) && traverse(root.right);
	}

}
