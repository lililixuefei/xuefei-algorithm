package leetcode.swordfingeroffer.unresolved;

/**
 * @description: 剑指 Offer 46. 把数字翻译成字符串
 * @author: xuefei
 * @date: 2023/07/24 22:57
 */
public class TranslateNum {

	public int translateNum(int num) {

		return process(String.valueOf(num).toCharArray(), 0);

	}

	public int process(char[] str, int i) {
		if (i == str.length) {
			return 1;
		}
		int ways = process(str, i + 1);
		if (i + 1 < str.length && str[i] != '0' && (str[i] - '0') * 10 + str[i + 1] - '0' < 27) {
			ways += process(str, i + 2);
		}
		return ways;
	}

	// 从右往左的动态规划
	public int dp(int num) {
		char[] str = String.valueOf(num).toCharArray();
		int n = str.length;
		int[] dp = new int[n + 1];
		dp[n] = 1;
		for (int i = n - 1; i >= 0; i--) {
			int ways = dp[i + 1];
			if (i + 1 < n && str[i] != '0' && (str[i] - '0') * 10 + str[i + 1] - '0' < 26) {
				ways += dp[i + 2];
			}
			dp[i] = ways;
		}
		return dp[0];
	}

	// 从左往右的动态规划
	public int dp2(int num) {
		char[] str = String.valueOf(num).toCharArray();
		int n = str.length;
		int[] dp = new int[n];
		dp[0] = 1;

		for (int i = 1; i < n; i++) {
			int ways = dp[i - 1];
			if (str[i - 1] != '0' && (str[i - 1] - '0') * 10 + str[i] - '0' < 26) {
				ways += (i - 2 >= 0 ? dp[i - 2] : 1);
			}
			dp[i] = ways;
		}
		return dp[n - 1];
	}

}
