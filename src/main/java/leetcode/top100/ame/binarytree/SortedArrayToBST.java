package leetcode.top100.ame.binarytree;

import labuladong.binarytree.TreeNode;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/31 14:55
 * @Version 1.0
 */
public class SortedArrayToBST {

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return process(nums, 0, nums.length - 1);
	}

	public TreeNode process(int[] nums, int i, int j) {
		if (i > j) {
			return null;
		}
		int mid = (i + j) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = process(nums, i, mid - 1);
		root.right = process(nums, mid + 1, j);
		return root;
	}

}
