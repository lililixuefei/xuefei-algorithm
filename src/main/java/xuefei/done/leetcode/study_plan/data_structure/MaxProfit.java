package xuefei.done.leetcode.study_plan.data_structure;

/**
 * @description: 买卖股票的最佳时机   https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 * @author: xuefei
 * @date: 2022/05/22 22:47
 */
public class MaxProfit {

    public static void main(String[] args) {

    }


    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}