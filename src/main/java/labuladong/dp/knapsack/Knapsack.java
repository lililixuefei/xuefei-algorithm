package labuladong.dp.knapsack;


/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/9 10:39 AM
 * @Version 1.0
 */
public class Knapsack {

    int knapsack(int W, int N, int[] wt, int[] val) {
        // List Integer 0，base case 已初始化
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w - wt[i - 1] < 0) {
                    // 当前背包容量装不下，只能选择不装入背包
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 装入或者不装入背包，择优
                    // 不可以。这两种写法的含义是不同的。
                    // dp[i][w] = Math.max(dp[i - 1][w - wt[i - 1]] + val[i - 1], dp[i - 1][w]);
                    // 这种写法是在选择装入第 i 个物品时，我们需要看的是装入第 i-1 个物品后，背包剩余容量 w - wt[i - 1] 的最大价值，然后再加上第 i 个物品的价值。
                    // 而 dp[i][w] = Math.max(dp[i][w - wt[i - 1]] + val[i - 1], dp[i - 1][w]);
                    // 这种写法则是在选择装入第 i 个物品时，我们需要看的是装入第 i 个物品后，背包剩余容量 w - wt[i - 1] 的最大价值，然后再加上第 i 个物品的价值。
                    // 这种写法实际上是允许重复选择物品，与题目的要求不符。
                    dp[i][w] = Math.max(dp[i - 1][w - wt[i - 1]] + val[i - 1], dp[i - 1][w]);
                }
            }
        }
        return dp[N][W];
    }

}
