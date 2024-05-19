package leetcode.top150;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/25 22:46
 * @Version 1.0
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }
        return maxProfit;
    }

}
