package leetcode.basic.dp.basic.string;

/**
 * @description: 编辑距离
 * @author: xuefei
 * @date: 2023/06/01 00:26
 */
public class MinDistance {

	public int minDistance(String word1, String word2) {

		char[] chars1 = word1.toCharArray();
		char[] chars2 = word2.toCharArray();

		int n = chars1.length + 1;
		int m = chars2.length + 1;

		int[][] dp = new int[n][m];

		for (int i = 1; i < n; i++) {
			dp[i][0] = i;
		}
		for (int j = 1; j < m; j++) {
			dp[0][j] = j;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (chars1[i - 1] == chars2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
				dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
			}
		}
		return dp[n - 1][m - 1];
	}

}
