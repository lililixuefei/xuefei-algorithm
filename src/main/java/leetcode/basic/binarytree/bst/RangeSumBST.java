package leetcode.basic.binarytree.bst;

import leetcode.basic.binarytree.TreeNode;

/**
 * @description: 二叉搜索树的范围和
 * @author: xuefei
 * @date: 2023/04/13 23:18
 */
public class RangeSumBST {


	public int rangeSumBST(leetcode.basic.binarytree.TreeNode root, int L, int R) {
		if (root == null) {
			return 0;
		}
		if (root.val < L) {
			return rangeSumBST(root.right, L, R);
		}
		if (root.val > R) {
			return rangeSumBST(root.left, L, R);
		}
		return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
	}


	int rangeSum = 0;

	public int rangeSumBST_me(TreeNode root, int low, int high) {
		if (root == null) {
			return 0;
		}

		int val = root.val;
		if (val >= low && val <= high) {
			rangeSum += val;
		}
		rangeSumBST(root.left, low, high);
		rangeSumBST(root.right, low, high);
		return rangeSum;
	}

}
