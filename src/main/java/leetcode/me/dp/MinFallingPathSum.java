package leetcode.me.dp;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/11/19 16:32
 * @Version 1.0
 */
public class MinFallingPathSum {


	public int minFallingPathSum(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				process(matrix, dp, i, j);
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			ans = Math.min(ans, dp[n - 1][i]);
		}
		return ans;
	}

	private void process(int[][] matrix, int[][] dp, int i, int j) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
			return;
		}
		int preValue1 = Integer.MAX_VALUE;
		if (i - 1 >= 0) {
			preValue1 = dp[i - 1][j];
		}
		int preValue2 = Integer.MAX_VALUE;
		if (i - 1 >= 0 && j - 1 >= 0) {
			preValue2 = dp[i - 1][j - 1];
		}
		int preValue3 = Integer.MAX_VALUE;
		if (i - 1 >= 0 && j + 1 < matrix[0].length) {
			preValue3 = dp[i - 1][j + 1];
		}
		int preValue = Math.min(preValue1, Math.min(preValue2, preValue3));
		preValue = preValue == Integer.MAX_VALUE ? 0 : preValue;
		dp[i][j] = matrix[i][j] + preValue;
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
