package leetcode.top100.ame.greed;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/8 22:36
 * @Version 1.0
 */
public class MaxProfit {

	public int maxProfit(int[] prices) {
		int maxProfit = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - min);
		}
		return maxProfit;
	}

}
