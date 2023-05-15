package zuoshen.follow;

/**
 * @description: 最长公共子序列
 * @author: xuefei
 * @date: 2023/05/14 18:30
 */
public class LongestCommonSubsequence {


	public static void main(String[] args) {
		String s1 = "abcd123gg";
		String s2 = "sssabcd123";
		System.out.println(longestCommonSubsequence1(s1, s2));
		System.out.println(longestCommonSubsequence2(s1, s2));
	}


	public static int longestCommonSubsequence1(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		// 尝试
		return process1(str1, str2, str1.length - 1, str2.length - 1, dp);
	}

	private static int process1(char[] str1, char[] str2, int i, int j, int[][] dp) {
		if (i < 0 || j < 0) {
			return 0;
		}
		if (dp[i][j] != 0) {
			return dp[i][j];
		}
		int ans = 0;
		if (str1[i] == str2[j]) {
			ans = 1 + process1(str1, str2, i - 1, j - 1, dp);
		} else {
			ans = Math.max(process1(str1, str2, i, j - 1, dp), process1(str1, str2, i - 1, j, dp));
		}
		dp[i][j] = ans;
		return ans;
	}


	public static int longestCommonSubsequence2(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		// 尝试
		return process2(str1, str2);
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
