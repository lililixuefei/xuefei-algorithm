package leetcode.basic.binarytree.bst;

import leetcode.basic.binarytree.TreeNode;

/**
 * @description: 二叉搜索树中的搜索
 * @author: xuefei
 * @date: 2023/04/13 23:25
 */
public class SearchBST {

	public leetcode.basic.binarytree.TreeNode searchBST(TreeNode root, int val) {
		if (root == null) {
			return root;
		}
		int nodeValue = root.val;
		if (nodeValue == val) {
			return root;
		}
		if (nodeValue > val) {
			return searchBST(root.left, val);
		} else {
			return searchBST(root.right, val);
		}
	}

}
