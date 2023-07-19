package leetcode.swordfingeroffer;

import labuladong.binarytree.TreeNode;

/**
 * @description: 剑指 Offer 55 - I. 二叉树的深度
 * @author: xuefei
 * @date: 2023/07/19 15:44
 */
public class MaxDepth {


	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int lDepth = maxDepth((root.left));
		int rDepth = maxDepth((root.right));
		return Math.max(lDepth, rDepth) + 1;
	}

}
