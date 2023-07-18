package leetcode.onequestion.unresolved;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: 包含每个查询的最小区间
 * @author: xuefei
 * @date: 2023/07/18 22:08
 */
public class MinInterval {

	public int[] minInterval(int[][] intervals, int[] queries) {
		int n = intervals.length;
		int m = queries.length;
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
		int[][] qs = new int[m][0];
		for (int i = 0; i < m; ++i) {
			qs[i] = new int[]{queries[i], i};
		}
		Arrays.sort(qs, Comparator.comparingInt(a -> a[0]));
		int[] ans = new int[m];
		Arrays.fill(ans, -1);
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		int i = 0;
		for (int[] q : qs) {
			while (i < n && intervals[i][0] <= q[0]) {
				int a = intervals[i][0];
				int b = intervals[i][1];
				pq.offer(new int[]{b - a + 1, b});
				++i;
			}
			while (!pq.isEmpty() && pq.peek()[1] < q[0]) {
				pq.poll();
			}
			if (!pq.isEmpty()) {
				ans[q[1]] = pq.peek()[0];
			}
		}
		return ans;
	}

}
