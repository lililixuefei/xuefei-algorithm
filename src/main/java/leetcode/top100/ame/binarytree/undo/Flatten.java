package leetcode.top100.ame.binarytree.undo;

import labuladong.binarytree.TreeNode;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/31 15:58
 * @Version 1.0
 */
public class Flatten {


	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		flatten(root.left);
		flatten(root.right);

		TreeNode right = root.right;
		root.right = root.left;
		root.left = null;
		TreeNode temp = root;
		while (temp.right != null) {
			temp = temp.right;
		}
		temp.right = right;
	}

}
