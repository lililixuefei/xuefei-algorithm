package leetcode.swordfingeroffer.unresolved;

/**
 * @description: 剑指 Offer 63. 股票的最大利润
 * @author: xuefei
 * @date: 2023/07/25 22:49
 */
public class MaxProfit {

	public int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int max = 0;
		int min = prices[0];
		for (int price : prices) {
			min = Math.min(price, min);
			max = Math.max(max, price - min);
		}
		return max;
	}

	public int maxProfit2(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int n = prices.length;
		int[][] dp = new int[n][2];
		for (int i = 0; i < n; i++) {
			if (i - 1 == -1) {
				// base case
				dp[i][0] = 0;
				dp[i][1] = -prices[i];
				continue;
			}
			// 手上没有持有股票
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			// 手上持有着股票
			dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
		}
		return dp[n - 1][0];
	}


}
