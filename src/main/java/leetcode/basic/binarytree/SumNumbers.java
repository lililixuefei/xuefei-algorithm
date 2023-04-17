package leetcode.basic.binarytree;

/**
 * @description: 求根节点到叶节点数字之和
 * @author: xuefei
 * @date: 2023/04/17 23:49
 */
public class SumNumbers {

	public int sumNumbers(TreeNode root) {
		return dfs(root, 0);
	}

	public int dfs(TreeNode root, int prevSum) {
		if (root == null) {
			return 0;
		}
		int sum = prevSum * 10 + root.val;
		if (root.left == null && root.right == null) {
			return sum;
		} else {
			return dfs(root.left, sum) + dfs(root.right, sum);
		}
	}

}
