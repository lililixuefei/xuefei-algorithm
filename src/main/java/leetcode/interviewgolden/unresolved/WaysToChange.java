package leetcode.interviewgolden.unresolved;

/**
 * @description: 硬币
 * @author: xuefei
 * @date: 2023/08/31 21:39
 */
public class WaysToChange {

    static final int MOD = 1000000007;
    int[] coins = {25, 10, 5, 1};

    public int waysToChange(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int c = 0; c < 4; ++c) {
            int coin = coins[c];
            for (int i = coin; i <= n; ++i) {
                f[i] = (f[i] + f[i - coin]) % MOD;
            }
        }
        return f[n];
    }

    public int waysToChange_wrong(int n) {

        int[] dp = new int[n + 1];
        int[] coins = new int[]{1, 5, 10, 25};
        dp[0] = 1;
        // dp方程：dp[i] += dp[i - coin];
        for (int i = 1; i <= n; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    break;
                }
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        return dp[n];
    }

}
