package leetcode.interviewgolden;

import labuladong.binarytree.TreeNode;

/**
 * @description: 合法二叉搜索树
 * @author: xuefei
 * @date: 2023/04/02 12:22
 */
public class IsValidBST {

	boolean isValidBST(TreeNode root) {
		return isValidBST(root, null, null);
	}

	/* 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val */
	boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
		// base case
		if (root == null) {
			return true;
		}
		// 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
		if (min != null && root.val <= min.val) {
			return false;
		}
		if (max != null && root.val >= max.val) {
			return false;
		}
		// 限定左子树的最大值是 root.val，右子树的最小值是 root.val
		return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
	}


	public boolean isValidBST_me_wrong(TreeNode root) {
		if (root == null) {
			return true;
		}
		int val = root.val;
		if (root.left != null && root.left.val > val) {
			return false;
		}
		if (root.right != null && root.right.val < val) {
			return false;
		}
		return isValidBST_me_wrong(root.left) && isValidBST_me_wrong(root.right);
	}

}
