package leetcode.basic.binarytree;

/**
 * @description: 完全二叉树的节点个数
 * @author: xuefei
 * @date: 2023/03/27 22:07
 */
public class CountNodes {

	int count = 0;

	public int countNodes(TreeNode root) {
		if (root == null){
			return 0;
		}
		count++;
		countNodes(root.left);
		countNodes(root.right);
		return count;
	}

}
