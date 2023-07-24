package leetcode.swordfingeroffer.unresolved;

import labuladong.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 剑指 Offer 34. 二叉树中和为某一值的路径
 * @author: xuefei
 * @date: 2023/07/24 22:50
 */
public class PathSum {


	List<List<Integer>> result;
	LinkedList<Integer> path;

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		result = new LinkedList<>();
		path = new LinkedList<>();
		traversal(root, targetSum);
		return result;
	}

	private void traversal(TreeNode root, int count) {
		if (root == null) {
			return;
		}
		path.offer(root.val);
		count -= root.val;
		if (root.left == null && root.right == null && count == 0) {
			result.add(new LinkedList<>(path));
		}
		traversal(root.left, count);
		traversal(root.right, count);
		path.removeLast();
	}

}
