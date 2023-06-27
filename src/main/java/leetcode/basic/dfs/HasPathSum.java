package leetcode.basic.dfs;

import xuefei.labuladong.binarytree.TreeNode;

/**
 * @description: 路径总和
 * @author: xuefei
 * @date: 2023/03/30 22:17
 */
public class HasPathSum {


	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			return sum == root.val;
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

}
