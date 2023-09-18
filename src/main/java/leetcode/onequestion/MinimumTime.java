package leetcode.onequestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 并行课程 III
 * @author: xuefei
 * @date: 2023/07/28 23:44
 */
public class MinimumTime {


	public int minimumTime(int n, int[][] relations, int[] time) {
		int mx = 0;
		List<Integer>[] prev = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			prev[i] = new ArrayList<>();
		}
		for (int[] relation : relations) {
			int x = relation[0];
			int y = relation[1];
			prev[x].add(y);
		}
		Map<Integer, Integer> memo = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			mx = Math.max(mx, dp(i, time, prev, memo));
		}
		return mx;
	}

	public int dp(int i, int[] time, List<Integer>[] prev, Map<Integer, Integer> memo) {
		if (!memo.containsKey(i)) {
			int cur = 0;
			for (int p : prev[i]) {
				cur = Math.max(cur, dp(p, time, prev, memo));
			}
			cur += time[i - 1];
			memo.put(i, cur);
		}
		return memo.get(i);
	}

}
