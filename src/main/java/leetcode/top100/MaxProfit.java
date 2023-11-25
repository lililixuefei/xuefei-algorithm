package leetcode.top100;

/**
 * @Description 买卖股票的最佳时机
 * @Author xuefei
 * @Date 2023/11/25 21:09
 * @Version 1.0
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            min = Math.min(price, min);
            maxProfit = Math.max(maxProfit, price - min);
        }
        return maxProfit;
    }

}
