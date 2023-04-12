package leetcode.basic.binarytree;

/**
 * @description: 所有大于等于节点的值之和
 * @author: xuefei
 * @date: 2023/04/12 23:26
 */
public class ConvertBST {

	public TreeNode convertBST(TreeNode root) {
		traverse(root);
		return root;
	}

	// 记录累加和
	int sum = 0;

	public void traverse(TreeNode root) {
		if (root == null) {
			return;
		}
		traverse(root.right);
		// 维护累加和
		sum += root.val;
		// 将 BST 转化成累加树
		root.val = sum;
		traverse(root.left);
	}

}
