package leetcode.basic.binarytree.nodone;

import leetcode.basic.binarytree.TreeNode;

/**
 * @description: 最大二叉树
 * @author: xuefei
 * @date: 2023/03/10 22:23
 */
public class ConstructMaximumBinaryTree {

	public TreeNode constructMaximumBinaryTree(int[] nums) {

		return constructMaximumBinaryTree(nums, 0, nums.length - 1);

	}

	public TreeNode constructMaximumBinaryTree(int[] nums, int i, int j) {
		if (i > j) {
			return null;
		}

		int index = -1;
		int maxValue = Integer.MIN_VALUE;
		for (int k = i; k <= j; k++) {
			if (nums[k] > maxValue) {
				index = k;
				maxValue = nums[k];
			}
		}
		TreeNode root = new TreeNode(maxValue);
		root.left = constructMaximumBinaryTree(nums, i, index - 1);
		root.right = constructMaximumBinaryTree(nums, index + 1, j);
		return root;

	}


}
