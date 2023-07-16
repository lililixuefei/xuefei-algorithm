package leetcode.onequestion.unresolved;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 树中距离之和
 * @author: xuefei
 * @date: 2023/07/16 14:12
 */
public class SumOfDistancesInTree {

	private List<List<Integer>> graph = new ArrayList<>();//邻接表
	int[] distSum; //距离和
	int[] nodeNum; //子树节点个数（包括自己）


	public static void main(String[] args) {
		SumOfDistancesInTree sumOfDistancesInTree = new SumOfDistancesInTree();

		int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};

		sumOfDistancesInTree.sumOfDistancesInTree(6, edges);

	}

	public int[] sumOfDistancesInTree(int N, int[][] edges) {

		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < edges.length; i++) {
			int src = edges[i][0];
			int dst = edges[i][1];
			graph.get(src).add(dst);
			graph.get(dst).add(src);
		}
		distSum = new int[N];
		nodeNum = new int[N];
		Arrays.fill(nodeNum, 1);
		postOrder(0, -1);
		preOrder(0, -1);
		return distSum;
	}

	//求root到子树所有节点的距离和
	private void postOrder(int root, int parent) {
		List<Integer> neighbors = graph.get(root);
		for (Integer neighbor : neighbors) {
			if (neighbor == parent) {
				continue; //如果邻接点是父节点，则跳过
			}
			postOrder(neighbor, root);
			nodeNum[root] += nodeNum[neighbor];
			distSum[root] += distSum[neighbor] + nodeNum[neighbor];
		}
	}

	//根据root计算其邻居到所在子树之外的节点的距离和（包括root节点）
	private void preOrder(int root, int parent) {
		List<Integer> neighbors = graph.get(root);
		for (Integer neighbor : neighbors) {
			if (neighbor == parent) {
				continue;
			}
			distSum[neighbor] = distSum[root] - nodeNum[neighbor] + (graph.size() - nodeNum[neighbor]);
			preOrder(neighbor, root);
		}
	}

}
