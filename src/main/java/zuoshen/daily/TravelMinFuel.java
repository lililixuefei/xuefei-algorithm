package zuoshen.daily;


import java.util.ArrayList;
import java.util.List;

/**
 * @description: 最少耗费多少汽油
 * @author: xuefei
 * @date: 2023/05/10 23:27
 */
public class TravelMinFuel {

	private static int cnt = 0;

	/**
	 * 给定两个数组 a 和 b ，比如
	 * a = {0,1,1}
	 * b = {1,2,3}
	 * a[0] = 0 ,b[0] = 1 ,表示 0 到 1有双向通路;
	 * 给定数字n,编号从 0 到 n ，所以一共有 n+1 个节点
	 * 题目输入保证所有节点都联通，且无环
	 * 默认办公室为0节点，每个节点都有一个居民，每天所有节点都要去节点0上班，所有的居民都有一辆5座的车，也都乐意和别人一起坐车
	 * 车不管负重多少,只要走过一条路都耗费一个油，求所有居民去办公室的路上，最少耗费多少汽油
	 *
	 * @param a
	 * @param b
	 * @param n
	 * @return
	 */
	public static int minFuel(int[] a, int[] b, int n) {
		// 先建图
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < a.length; i++) {
			graph.get(a[i]).add(b[i]);
			graph.get(b[i]).add(a[i]);
		}

		// a 号  dfn[a] == 0 没遍历过  dfn[a] != 0 遍历过
		int[] dfn = new int[n + 1];
		// a 为头的数，一共有10个节点
		int[] size = new int[n + 1];
		// cast[a] 所有居民汇聚到a耗费的总量汽油
		int[] cost = new int[n + 1];
		cnt = 0;
		dfs(graph, 0, dfn, size, cost);

		return cost[0];
	}

	private static void dfs(List<List<Integer>> graph, int cur, int[] dfn, int[] size, int[] cost) {
		dfn[cur] = ++cnt;
		size[cur] = 1;
		for (Integer next : graph.get(cur)) {
			if (dfn[next] == 0) {
				dfs(graph, next, dfn, size, cost);
				size[cur] += size[next];
				cost[cur] += cost[next];
				cost[cur] += (size[next] + 4) / 5;
			}
		}
	}


}
