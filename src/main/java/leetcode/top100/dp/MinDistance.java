package leetcode.top100.dp;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/24 19:36
 * @Version 1.0
 */
public class MinDistance {

	public int minDistance(String s1, String s2) {
		int m = s1.length(), n = s2.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			dp[i][0] = i;
		}
		for (int j = 1; j <= n; j++) {
			dp[0][j] = j;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1);
				}
			}
		}
		return dp[m][n];
	}

	private static int min(int i, int j, int k) {
		return Math.min(i, Math.min(j, k));
	}


}
