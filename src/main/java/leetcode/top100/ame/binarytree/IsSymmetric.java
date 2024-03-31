package leetcode.top100.ame.binarytree;

import labuladong.binarytree.TreeNode;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/31 14:30
 * @Version 1.0
 */
public class IsSymmetric {

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return process(root.left, root.right);
	}

	public boolean process(TreeNode left, TreeNode right) {
		if (left == null ^ right == null) {
			return false;
		}
		if (left == null) {
			return true;
		}
		if (left.val != right.val) {
			return false;
		}
		return process(left.left, right.right) && process(left.right, right.left);
	}

}
