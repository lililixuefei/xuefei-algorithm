package leetcode.basic.binarytree;

import java.util.*;

/**
 * @description: 层数最深叶子节点的和
 * @author: xuefei
 * @date: 2023/04/12 23:32
 */
public class DeepestLeavesSum {


	int maxLevel = -1;
	int sum = 0;

	public int deepestLeavesSum(TreeNode root) {
		dfs(root, 0);
		return sum;
	}

	public void dfs(TreeNode node, int level) {
		if (node == null) {
			return;
		}
		if (level > maxLevel) {
			maxLevel = level;
			sum = node.val;
		} else if (level == maxLevel) {
			sum += node.val;
		}
		dfs(node.left, level + 1);
		dfs(node.right, level + 1);
	}


	public int deepestLeavesSum_me(TreeNode root) {
		List<List<Integer>> levelNodes = new ArrayList<>();
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offer(root);
		while (!deque.isEmpty()) {
			int size = deque.size();
			List<Integer> nodeValues = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = deque.poll();
				nodeValues.add(node.val);
				if (node.left != null) {
					deque.offer(node.left);
				}
				if (node.right != null) {
					deque.offer(node.right);
				}
			}
			levelNodes.add(nodeValues);
		}
		return levelNodes.get(levelNodes.size() - 1).stream().mapToInt(Integer::intValue).sum();
	}

}
