package leetcode.basic.dp.basic.knapsack;


/**
 * @description: 完全平方数
 * @author: xuefei
 * @date: 2023/06/27 23:42
 */
public class NumSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                // 动态转移方程
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

}
