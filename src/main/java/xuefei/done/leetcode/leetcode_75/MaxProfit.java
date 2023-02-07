package xuefei.done.leetcode.leetcode_75;

/**
 * @description: 买卖股票的最佳时机   https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 * @author: xuefei
 * @date: 2022/06/30 22:23
 */
public class MaxProfit {



    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int price : prices) {
            if (price < minprice) {
                minprice = price;
            } else if (price - minprice > maxprofit) {
                maxprofit = price - minprice;
            }
        }
        return maxprofit;
    }
}
