package leetcode.me;

import java.util.Arrays;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/11/17 20:07
 */
public class CoinChange {

    // coins 中是可选硬币面值，amount 是目标金额
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

}
