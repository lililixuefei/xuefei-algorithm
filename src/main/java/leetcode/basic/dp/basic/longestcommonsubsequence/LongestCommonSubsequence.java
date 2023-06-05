package leetcode.basic.dp.basic.longestcommonsubsequence;

/**
 * @description: 最长公共子序列
 * @author: xuefei
 * @date: 2023/06/05 23:36
 */
public class LongestCommonSubsequence {

	public int longestCommonSubsequence(String text1, String text2) {
		char[] chars1 = text1.toCharArray();
		char[] chars2 = text2.toCharArray();
		int n = chars1.length;
		int m = chars2.length;

		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (chars1[i - 1] == chars2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		return dp[n][m];
	}

}
