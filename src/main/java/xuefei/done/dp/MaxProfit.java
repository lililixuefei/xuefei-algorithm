package xuefei.done.dp;

/**
 * @description: 买卖股票的最佳时机   https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 * @author: xuefei
 * @date: 2022/07/05 23:42
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

}
