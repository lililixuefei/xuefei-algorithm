package labuladong.dp.maxprofit;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/6/25 11:02 AM
 * @Version 1.0
 */
public class MaxProfit_k_inf {

	// 原始版本
	int maxProfit_k_inf(int[] prices) {
		int n = prices.length;
		int[][] dp = new int[n][2];

		// base case
		dp[0][0] = 0;
		dp[0][1] = -prices[0];

		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
		}
		return dp[n - 1][0];
	}


	// 空间复杂度优化版本
	int maxProfit_k_inf_good(int[] prices) {
		int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int temp = dp_i_0;
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
		}
		return dp_i_0;
	}

}
