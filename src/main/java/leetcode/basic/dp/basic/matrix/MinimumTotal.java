package leetcode.basic.dp.basic.matrix;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;

/**
 * @description: 三角形最小路径和
 * @author: xuefei
 * @date: 2023/05/30 00:14
 */
public class MinimumTotal {

	public int minimumTotal_dp(List<List<Integer>> triangle) {
		int n = triangle.size();
		// dp[i][j] 表示从点 (i, j) 到底边的最小路径和。
		int[][] dp = new int[n + 1][n + 1];
		// 从三角形的最后一行开始递推。
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
			}
		}
		return dp[0][0];
	}


	public int minimumTotal(List<List<Integer>> triangle) {

		return process(triangle, 0, 0, new HashMap<Pair, Integer>());
	}

	public int process(List<List<Integer>> triangle, int i, int j, HashMap<Pair, Integer> dp) {
		int size1 = triangle.size();
		if (i >= size1) {
			return 0;
		}
		int size2 = triangle.get(i).size();
		// 边界
		if (j >= size2) {
			return 0;
		}

		Pair p = new Pair(i, j);
		if (dp.containsKey(p)) {
			return dp.get(p);
		}

		int ans1 = process(triangle, i + 1, j, dp) + triangle.get(i).get(j);

		int ans2 = process(triangle, i + 1, j + 1, dp) + triangle.get(i).get(j);

		int ans = Math.min(ans1, ans2);

		dp.put(p, ans);
		return ans;

	}


}
