package leetcode.basic.dp.basic.tree;

import leetcode.basic.binarytree.bst.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 打家劫舍 III
 * @author: xuefei
 * @date: 2023/06/19 23:27
 */
public class Rob {


	public int rob_3(TreeNode root) {
		int[] result = robInternal(root);
		return Math.max(result[0], result[1]);
	}

	public int[] robInternal(TreeNode root) {
		if (root == null) {
			return new int[2];
		}
		int[] result = new int[2];

		int[] left = robInternal(root.left);
		int[] right = robInternal(root.right);

		result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		result[1] = left[0] + right[0] + root.val;

		return result;
	}


	public int rob_2(TreeNode root) {
		HashMap<TreeNode, Integer> memo = new HashMap<>();
		return robInternal(root, memo);
	}

	public int robInternal(TreeNode root, Map<TreeNode, Integer> memo) {
		if (root == null) {
			return 0;
		}
		if (memo.containsKey(root)) {
			return memo.get(root);
		}
		int money = root.val;

		if (root.left != null) {
			money += (robInternal(root.left.left, memo) + robInternal(root.left.right, memo));
		}
		if (root.right != null) {
			money += (robInternal(root.right.left, memo) + robInternal(root.right.right, memo));
		}
		int result = Math.max(money, robInternal(root.left, memo) + robInternal(root.right, memo));
		memo.put(root, result);
		return result;
	}


	public int rob(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int money = root.val;
		if (root.left != null) {
			money += (rob(root.left.left) + rob(root.left.right));
		}

		if (root.right != null) {
			money += (rob(root.right.left) + rob(root.right.right));
		}

		return Math.max(money, rob(root.left) + rob(root.right));
	}


}
