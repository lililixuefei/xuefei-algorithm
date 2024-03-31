package leetcode.top100.ame.binarytree;

import labuladong.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/31 14:47
 * @Version 1.0
 */
public class LevelOrder {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offer(root);
		while (!deque.isEmpty()) {
			int size = deque.size();
			List<Integer> curAns = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = deque.poll();
				curAns.add(node.val);
				if (node.left != null) {
					deque.add(node.left);
				}
				if (node.right != null) {
					deque.add(node.right);
				}
			}
			ans.add(curAns);
		}
		return ans;
	}

}
