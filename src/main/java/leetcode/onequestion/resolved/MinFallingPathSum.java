package leetcode.onequestion.resolved;

import java.util.Arrays;

/**
 * @description: 下降路径最小和
 * @author: xuefei
 * @date: 2023/07/13 23:12
 */
public class MinFallingPathSum {

	// 备忘录
	static int[][] memo;

	public static int minFallingPathSum(int[][] matrix) {
		int res = Integer.MAX_VALUE;
		int n = matrix.length;

		// 备忘录里的值初始化为 66666
		memo = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(memo[i], 66666);
		}
		for (int i = 0; i < n; i++) {
			int ans = process(matrix, 0, i);
			res = Math.min(res, ans);
		}
		return res;
	}

	static int process(int[][] matrix, int i, int j) {
		int n = matrix.length;
		if (i < 0 || j >= n || i >= n || j < 0) {
			return 99999;
		}
		int curValue = matrix[i][j];

		if (i == n - 1) {
			return curValue;
		}
		if (memo[i][j] != 66666) {
			return memo[i][j];
		}

		int i1 = curValue + process(matrix, i + 1, j);
		int i2 = curValue + process(matrix, i + 1, j + 1);
		int i3 = curValue + process(matrix, i + 1, j - 1);

		memo[i][j] = Math.min(i1, Math.min(i2, i3));
		return memo[i][j];
	}


	public int minFallingPathSum2(int[][] matrix) {
		int n = matrix.length;

		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			dp[0][i] = matrix[0][i];
		}

		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + matrix[i][0];
			for (int j = 1; j < n - 1; j++) {
				dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])) + matrix[i][j];
			}
			dp[i][n - 1] = Math.min(dp[i - 1][n - 2], dp[i - 1][n - 1]) + matrix[i][n - 1];
		}


		int ans = Integer.MAX_VALUE;
		for (int i : dp[n - 1]) {
			ans = Math.min(ans, i);
		}
		return ans;
	}

}