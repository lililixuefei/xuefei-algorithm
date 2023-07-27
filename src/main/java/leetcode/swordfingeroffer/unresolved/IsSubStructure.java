package leetcode.swordfingeroffer.unresolved;

import labuladong.binarytree.TreeNode;

/**
 * @description: 剑指 Offer 26. 树的子结构
 * @author: xuefei
 * @date: 2023/07/25 23:45
 */
public class IsSubStructure {

	public boolean isSubStructure(TreeNode A, TreeNode B) {
		return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
	}

	boolean recur(TreeNode A, TreeNode B) {
		if (B == null) {
			return true;
		}
		if (A == null || A.val != B.val) {
			return false;
		}
		return recur(A.left, B.left) && recur(A.right, B.right);
	}

}
