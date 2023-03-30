package leetcode.basic.dfs;

import labuladong.binarytree.TreeNode;

/**
 * @description: 二叉搜索树的第k大节点
 * @author: xuefei
 * @date: 2023/03/30 23:01
 */
public class KthLargest {

	int res;
	int rank;
	public int kthLargest(TreeNode root, int k) {
		dfs(root, k);
		return res;
	}

	void dfs(TreeNode root, int k) {
		if (root == null) {
			return;
		}
		dfs(root.right, k);
		rank++;
		if (k == rank) {
			res = root.val;
			return;
		}
		dfs(root.left, k);
	}

}
