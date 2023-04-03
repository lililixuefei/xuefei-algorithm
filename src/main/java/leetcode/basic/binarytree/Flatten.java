package leetcode.basic.binarytree;

/**
 * @description: 二叉树展开为链表
 * @author: xuefei
 * @date: 2023/04/03 23:39
 */
public class Flatten {

	public void flatten(TreeNode root) {
		// base case
		if (root == null) {
			return;
		}

		// 利用定义，把左右子树拉平
		flatten(root.left);
		flatten(root.right);

		// 1、左右子树已经被拉平成一条链表
		TreeNode left = root.left;
		TreeNode right = root.right;

		// 2、将左子树作为右子树
		root.left = null;
		root.right = left;

		// 3、将原先的右子树接到当前右子树的末端
		TreeNode p = root;
		while (p.right != null) {
			p = p.right;
		}
		p.right = right;
	}

}
