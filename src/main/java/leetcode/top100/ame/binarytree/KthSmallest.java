package leetcode.top100.ame.binarytree;

import labuladong.binarytree.TreeNode;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/31 15:16
 * @Version 1.0
 */
public class KthSmallest {

	int rank = 0;
	int ans = 0;

	public int kthSmallest(TreeNode root, int k) {
		process(root, k);
		return ans;
	}

	public void process(TreeNode root, int k) {
		if (root == null) {
			return;
		}
		process(root.left, k);
		rank++;
		if (rank == k) {
			ans = root.val;
			return;
		}
		process(root.right, k);
	}

}
