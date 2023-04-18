package leetcode.basic.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 克隆图
 * @author: xuefei
 * @date: 2023/04/18 23:35
 */
public class CloneGraph {

	public Node cloneGraph(Node node) {
		return node;
	}


	// Definition for a Node.
	static class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

}
