package leetcode.basic.binarytree;

/**
 * @description: 二叉树剪枝
 * @author: xuefei
 * @date: 2023/04/14 00:05
 */
public class PruneTree {

	public TreeNode pruneTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		root.left = pruneTree(root.left);
		root.right = pruneTree(root.right);
		if (root.left == null && root.right == null && root.val == 0) {
			return null;
		}
		return root;
	}


}
