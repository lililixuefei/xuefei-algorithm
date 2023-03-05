package leetcode.basic.binarysearch.nodone;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @description: 矩阵中战斗力最弱的 K 行
 * @author: xuefei
 * @date: 2023/03/05 14:45
 */
public class KWeakestRows {

	public int[] kWeakestRows_good(int[][] mat, int k) {
		int m = mat.length;
		int n = mat[0].length;
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
			if (a[0] == b[0]) {
				return b[1] - a[1];
			}
			return b[0] - a[0];
		});
		for (int i = 0; i < m; i++) {
			int l = 0;
			int r = n - 1;
			while (l < r) {
				int mid = l + r + 1 >> 1;
				if (mat[i][mid] >= 1) {
					l = mid;
				} else {
					r = mid - 1;
				}
			}
			int cur = mat[i][r] >= 1 ? r + 1 : r;
			if (q.size() == k && q.peek()[0] > cur) {
				q.poll();
			}
			if (q.size() < k) {
				q.add(new int[]{cur, i});
			}
		}
		int[] ans = new int[k];
		int idx = k - 1;
		while (!q.isEmpty()) {
			ans[idx--] = q.poll()[1];
		}
		return ans;
	}


	public int[] kWeakestRows(int[][] mat, int k) {
		int m = mat.length;
		int n = mat[0].length;
		int[][] all = new int[m][2];
		for (int i = 0; i < m; i++) {
			int cur = 0;
			for (int j = 0; j < n; j++) {
				cur += mat[i][j];
			}
			all[i] = new int[]{cur, i};
		}
		Arrays.sort(all, (a, b) -> {
			if (a[0] != b[0]) {
				return a[0] - b[0];
			}
			return a[1] - b[1];
		});
		int[] ans = new int[k];
		for (int i = 0; i < k; i++) {
			ans[i] = all[i][1];
		}
		return ans;
	}


}
