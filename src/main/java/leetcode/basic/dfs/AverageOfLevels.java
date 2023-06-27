package leetcode.basic.dfs;

import xuefei.labuladong.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 二叉树的层平均值
 * @author: xuefei
 * @date: 2023/04/20 23:08
 */
public class AverageOfLevels {

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> averageOfLevels = new ArrayList<>();

		Deque<TreeNode> deque = new LinkedList<>();
		deque.offer(root);
		while (!deque.isEmpty()) {
			int size = deque.size();
			double average = 0d;
			for (int i = 0; i < size; i++) {
				TreeNode treeNode = deque.poll();
				average += treeNode.val;
				if (treeNode.left != null) {
					deque.offer(treeNode.left);
				}
				if (treeNode.right != null) {
					deque.offer(treeNode.right);
				}
			}
			average = average / size;
			averageOfLevels.add(average);
		}
		return averageOfLevels;
	}

}
