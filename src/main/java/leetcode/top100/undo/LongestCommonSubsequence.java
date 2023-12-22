package leetcode.top100.undo;

/**
 * @Description 最长公共子序列
 * @Author xuefei
 * @Date 2023/12/23 00:06
 * @Version 1.0
 */
public class LongestCommonSubsequence {

	public int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();
		int[][] dp = new int[m + 1][n + 1];


		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (text1.charAt(i) == text2.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[m][n];


	}

}
