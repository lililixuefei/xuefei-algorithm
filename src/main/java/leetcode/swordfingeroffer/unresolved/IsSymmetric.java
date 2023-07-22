package leetcode.swordfingeroffer.unresolved;

import labuladong.binarytree.TreeNode;

/**
 * @description: 剑指 Offer 28. 对称的二叉树
 * @author: xuefei
 * @date: 2023/07/19 16:12
 */
public class IsSymmetric {

	public boolean isSymmetric(TreeNode root) {

		return process(root, root);
	}

	public boolean process(TreeNode p, TreeNode q) {
		if (p == null ^ q == null) {
			return false;
		}
		if (p == null) {
			return true;
		}
		return p.val == q.val && process(p.left, q.right) && process(p.right, q.left);
	}

}
