package labuladong.dp;

import java.util.Arrays;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/6/25 3:06 PM
 * @Version 1.0
 */
public class MinPathSum {


	int minPathSum_3(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];

		dp[0][0] = grid[0][0];

		for (int i = 1; i < m; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}

		for (int j = 1; j < n; j++) {
			dp[0][j] = dp[0][j - 1] + grid[0][j];
		}

		// 状态转移
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}

		return dp[m - 1][n - 1];
	}


	int[][] memo;

	int minPathSum_2(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		// 构造备忘录，初始值全部设为 -1
		memo = new int[m][n];
		for (int[] row : memo) {
			Arrays.fill(row, -1);
		}

		return dp_2(grid, m - 1, n - 1);
	}


	int dp_2(int[][] grid, int i, int j) {
		// base case
		if (i == 0 && j == 0) {
			return grid[0][0];
		}
		if (i < 0 || j < 0) {
			return Integer.MAX_VALUE;
		}
		// 避免重复计算
		if (memo[i][j] != -1) {
			return memo[i][j];
		}
		// 将计算结果记入备忘录
		memo[i][j] = Math.min(
				dp_2(grid, i - 1, j),
				dp_2(grid, i, j - 1)
		) + grid[i][j];

		return memo[i][j];
	}


	int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		// 计算从左上角走到右下角的最小路径和
		return dp(grid, m - 1, n - 1);
	}

	int dp(int[][] grid, int i, int j) {
		// base case
		if (i == 0 && j == 0) {
			return grid[0][0];
		}
		// 如果索引出界，返回一个很大的值，
		// 保证在取 min 的时候不会被取到
		if (i < 0 || j < 0) {
			return Integer.MAX_VALUE;
		}

		// 左边和上面的最小路径和加上 grid[i][j]
		// 就是到达 (i, j) 的最小路径和
		return Math.min(dp(grid, i - 1, j), dp(grid, i, j - 1)) + grid[i][j];
	}

}
