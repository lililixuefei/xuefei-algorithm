package leetcode.basic.binarytree.bst;

import leetcode.basic.binarytree.TreeNode;

/**
 * @description: 递增顺序搜索树
 * @author: xuefei
 * @date: 2023/04/13 23:46
 */
public class IncreasingBST {

	leetcode.basic.binarytree.TreeNode dummy = new leetcode.basic.binarytree.TreeNode(-1);
	leetcode.basic.binarytree.TreeNode temp = dummy;

	public leetcode.basic.binarytree.TreeNode increasingBST(leetcode.basic.binarytree.TreeNode root) {
		if (root == null){
			return null;
		}
		increasingBST(root.left);

		leetcode.basic.binarytree.TreeNode node = new TreeNode(root.val);
		temp.right = node;
		temp = node;

		increasingBST(root.right);
		return dummy.right;
	}

}
