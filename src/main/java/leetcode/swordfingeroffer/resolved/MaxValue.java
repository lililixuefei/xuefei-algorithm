package leetcode.swordfingeroffer.resolved;

/**
 * @description: 剑指 Offer 47. 礼物的最大价值
 * @author: xuefei
 * @date: 2023/07/25 23:32
 */
public class MaxValue {

	public static void main(String[] args) {
		int[][] grid = {{1, 2, 5}
				, {3, 2, 1}};
		maxValue(grid);
	}

	public static int maxValue(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[][] dp = new int[n][m];
		dp[0][0] = grid[0][0];
		for (int i = 1; i < m; i++) {
			dp[0][i] = dp[0][i - 1] + grid[0][i];
		}
		for (int i = 1; i < n; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}
		return dp[n - 1][m - 1];
	}
}