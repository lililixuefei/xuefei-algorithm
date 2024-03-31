package leetcode.top100.ame.binarytree;

import labuladong.binarytree.TreeNode;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/31 15:05
 * @Version 1.0
 */
public class IsValidBST {

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isValidBST(root, null, null);
	}

	public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
		if (root == null) {
			return true;
		}
		if (max != null && root.val >= max.val) {
			return false;
		}
		if (min != null && root.val <= min.val) {
			return false;
		}
		return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
	}

}
