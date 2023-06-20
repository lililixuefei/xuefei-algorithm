package leetcode.basic.dp.basic.statemachine;

/**
 * @description: 最佳买卖股票时机含冷冻期
 * @author: xuefei
 * @date: 2023/06/20 23:19
 */
public class MaxProfit {

	public int maxProfit(int[] prices) {
		int n = prices.length;
		if (n <= 1) {
			return 0;
		}

		int[][] dp = new int[n][3];
		dp[0][0] = 0;
		dp[0][1] = -1 * prices[0];
		dp[0][2] = 0;

		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
			dp[i][2] = dp[i - 1][1] + prices[i];

		}
		return Math.max(dp[n - 1][0], dp[n - 1][2]);
	}

}
