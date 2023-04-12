package leetcode.basic.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 在每个树行中找最大值
 * @author: xuefei
 * @date: 2023/04/13 00:01
 */
public class LargestValues {

	public List<Integer> largestValues(TreeNode root) {
		List<Integer> largestValues = new ArrayList<>();
		if (null == root) {
			return largestValues;
		}
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offer(root);
		while (!deque.isEmpty()) {
			int size = deque.size();
			int maxValue = Integer.MIN_VALUE;
			for (int i = 0; i < size; i++) {
				TreeNode node = deque.poll();
				maxValue = Math.max(node.val, maxValue);
				if (node.left != null) {
					deque.offer(node.left);
				}
				if (node.right != null) {
					deque.offer(node.right);
				}
			}
			largestValues.add(maxValue);
		}
		return largestValues;
	}

}
