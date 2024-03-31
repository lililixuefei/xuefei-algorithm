package leetcode.top100.ame.binarytree;

import labuladong.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/31 15:22
 * @Version 1.0
 */
public class RightSideView {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offer(root);
		while (!deque.isEmpty()) {
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = deque.poll();
				if (node.left != null) {
					deque.add(node.left);
				}
				if (node.right != null) {
					deque.add(node.right);
				}
				if (i == size - 1) {
					ans.add(node.val);
				}
			}
		}
		return ans;
	}

}
