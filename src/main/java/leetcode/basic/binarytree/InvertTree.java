package leetcode.basic.binarytree;

/**
 * @description: 翻转二叉树
 * @author: xuefei
 * @date: 2023/02/25 13:45
 */
public class InvertTree {

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode tmp = root.right;
		root.right = root.left;
		root.left = tmp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}

}
