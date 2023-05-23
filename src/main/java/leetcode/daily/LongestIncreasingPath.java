package leetcode.daily;

/**
 * @description: 矩阵中的最长递增路径
 * @author: xuefei
 * @date: 2023/05/23 23:04
 */
public class LongestIncreasingPath {

	public int longestIncreasingPath(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];

		int ans = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				ans = Math.max(ans, process(matrix, i, j, dp));
			}
		}
		return ans;
	}

	// 从m[i][j]开始走，走出来的最长递增链，返回！
	public static int process(int[][] m, int i, int j, int[][] dp) {
		if (dp[i][j] != 0) {
			return dp[i][j];
		}
		int up = i > 0 && m[i][j] < m[i - 1][j] ? process(m, i - 1, j, dp) : 0;
		int down = i < (m.length - 1) && m[i][j] < m[i + 1][j] ? process(m, i + 1, j, dp) : 0;
		int left = j > 0 && m[i][j] < m[i][j - 1] ? process(m, i, j - 1, dp) : 0;
		int right = j < (m[0].length - 1) && m[i][j] < m[i][j + 1] ? process(m, i, j + 1, dp) : 0;
		int ans = Math.max(Math.max(up, down), Math.max(left, right)) + 1;
		dp[i][j] = ans;
		return ans;
	}


}
