package leetcode.basic.dp.basic.matrix;

/**
 * @description: 下降路径最小和
 * @author: xuefei
 * @date: 2023/05/30 23:07
 */
public class MinFallingPathSum {

	public static void main(String[] args) {
		int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};

		System.out.println(minFallingPathSum(matrix));
	}

	public static int minFallingPathSum(int[][] matrix) {
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
