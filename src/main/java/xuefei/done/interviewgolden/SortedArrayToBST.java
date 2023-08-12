package xuefei.done.interviewgolden;

import leetcode.basic.binarytree.bst.TreeNode;

/**
 * @description: 最小高度树
 * @author: xuefei
 * @date: 2023/04/02 12:20
 */
public class SortedArrayToBST {

	public TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}

	public TreeNode helper(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}

		// 总是选择中间位置左边的数字作为根节点
		int mid = (left + right) / 2;

		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, left, mid - 1);
		root.right = helper(nums, mid + 1, right);
		return root;
	}

}
