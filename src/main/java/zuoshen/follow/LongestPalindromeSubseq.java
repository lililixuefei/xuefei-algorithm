package zuoshen.follow;


/**
 * @description: 最长回文子序列
 * @author: xuefei
 * @date: 2023/05/14 21:40
 */
public class LongestPalindromeSubseq {

	public static int longestPalindromeSubseq(String s1) {
		if (s1 == null || s1.length() == 0) {
			return 0;
		}
		char[] str1 = s1.toCharArray();
		char[] str2 = reverse(str1);
		// 尝试
		return process2(str1, str2);
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
