package leetcode.basic.dfs;

import xuefei.labuladong.binarytree.TreeNode;

/**
 * @description: 二叉树的坡度
 * @author: xuefei
 * @date: 2023/03/30 22:51
 */
public class FindTilt {

	int ans = 0;

	public int findTilt(TreeNode root) {
		dfs(root);
		return ans;
	}

	public int dfs(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int sumLeft = dfs(node.left);
		int sumRight = dfs(node.right);
		ans += Math.abs(sumLeft - sumRight);
		return sumLeft + sumRight + node.val;
	}

}
