package leetcode.basic.dp.basic.lcs;

/**
 * @description: 让字符串成为回文串的最少插入次数
 * @author: xuefei
 * @date: 2023/06/18 20:58
 */
public class MinInsertions {

	public int minInsertions(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
				}
			}
		}
		return dp[0][n - 1];

	}


	public static int minInsertions_2(String s1) {
		if (s1 == null || s1.length() == 0) {
			return 0;
		}
		char[] str1 = s1.toCharArray();
		char[] str2 = reverse(str1);
		// 尝试
		return s1.length() - process2(str1, str2);
	}

	public static char[] reverse(char[] str) {
		int N = str.length;
		char[] reverse = new char[str.length];
		for (int i = 0; i < str.length; i++) {
			reverse[--N] = str[i];
		}
		return reverse;
	}


	private static int process2(char[] str1, char[] str2) {
		int m = str1.length;
		int n = str2.length;
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				// 现在 i 和 j 从 1 开始，所以要减一
				if (str1[i - 1] == str2[j - 1]) {
					// s1[i-1] 和 s2[j-1] 必然在 lcs 中
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					// s1[i-1] 和 s2[j-1] 至少有一个不在 lcs 中
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		return dp[m][n];
	}

}
