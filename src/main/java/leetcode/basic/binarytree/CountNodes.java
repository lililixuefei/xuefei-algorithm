package leetcode.basic.binarytree;

/**
 * @description: 完全二叉树的节点个数
 * @author: xuefei
 * @date: 2023/03/27 22:07
 */
public class CountNodes {

	public int countNodes_2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return countNodes(root.left) + countNodes(root.right) + 1;
	}


	int count = 0;

	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		count++;
		countNodes(root.left);
		countNodes(root.right);
		return count;
	}

}
