package labuladong.binarytree.bst;

import labuladong.binarytree.TreeNode;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/7/25 11:34 AM
 * @Version 1.0
 */
public class TrimBST {

	public TreeNode trimBST(TreeNode root, int low, int high) {
		if (root == null) {
			return null;
		}
		if (root.val < low) {
			return trimBST(root.right, low, high);
		}
		if (root.val > high) {
			return trimBST(root.left, low, high);
		}
		// root在[low,high]范围内
		root.left = trimBST(root.left, low, high);
		root.right = trimBST(root.right, low, high);
		return root;
	}

}
