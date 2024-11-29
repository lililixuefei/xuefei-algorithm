package leetcode.top100.dp.maxprofit;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/6/25 11:11 AM
 * @Version 1.0
 */
public class MaxProfit_k_2 {

	// 原始版本
	int maxProfit_k_2(int[] prices) {
		int max_k = 2, n = prices.length;
		int[][][] dp = new int[n][max_k + 1][2];
		for (int i = 0; i < n; i++) {
			for (int k = max_k; k >= 1; k--) {
				if (i - 1 == -1) {
					// 处理 base case
					dp[i][k][0] = 0;
					dp[i][k][1] = -prices[i];
					continue;
				}
				dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
				dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
			}
		}
		// 穷举了 n × max_k × 2 个状态，正确。
		return dp[n - 1][max_k][0];
	}

	// 状态转移方程：
	// dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + prices[i])
	// dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - prices[i])
	// dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
	// dp[i][1][1] = max(dp[i-1][1][1], -prices[i])

	// 空间复杂度优化版本
	int maxProfit_k_2_good(int[] prices) {
		// base case
		int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
		int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
		for (int price : prices) {
			dp_i20 = Math.max(dp_i20, dp_i21 + price);
			dp_i21 = Math.max(dp_i21, dp_i10 - price);
			dp_i10 = Math.max(dp_i10, dp_i11 + price);
			dp_i11 = Math.max(dp_i11, -price);
		}
		return dp_i20;
	}

}
