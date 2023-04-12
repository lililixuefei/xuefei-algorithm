package leetcode.basic.binarytree;

/**
 * @description: 计算布尔二叉树的值
 * @author: xuefei
 * @date: 2023/04/12 23:54
 */
public class EvaluateTree {

	public boolean evaluateTree(TreeNode root) {
		if (root.left == null) {
			return root.val == 1;
		}
		if (root.val == 2) {
			return evaluateTree(root.left) || evaluateTree(root.right);
		} else {
			return evaluateTree(root.left) && evaluateTree(root.right);
		}
	}


}
