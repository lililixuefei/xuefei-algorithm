package leetcode.basic.binarytree;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/02/25 13:46
 */
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

