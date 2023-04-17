package leetcode.basic.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @description: N 叉树的最大深度
 * @author: xuefei
 * @date: 2023/04/18 00:27
 */
public class MaxDepth {

	public int maxDepth_dfs(Node root) {
		if (root == null) {
			return 0;
		}
		int ans = 0;
		for (Node node : root.children) {
			ans = Math.max(ans, maxDepth_dfs(node));
		}
		return ans + 1;
	}

	public int maxDepth_bfs(Node root) {
		if (root == null) {
			return 0;
		}
		int ans = 0;
		Deque<Node> d = new ArrayDeque<>();
		d.addLast(root);
		while (!d.isEmpty()) {
			int size = d.size();
			while (size-- > 0) {
				Node t = d.pollFirst();
				for (Node node : t.children) {
					d.addLast(node);
				}
			}
			ans++;
		}
		return ans;
	}


	// Definition for a Node.
	static class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}
}
