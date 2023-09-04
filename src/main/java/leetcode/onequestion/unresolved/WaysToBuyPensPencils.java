package leetcode.onequestion.unresolved;

/**
 * @description: 买钢笔和铅笔的方案数
 * @author: xuefei
 * @date: 2023/09/04 22:47
 */
public class WaysToBuyPensPencils {

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long n = 1 + total / cost1;
        long ans = n;
        for (long i = 0; i < n; i++) {
            ans += (total - cost1 * i) / cost2;
        }
        return ans;
    }

    public long waysToBuyPensPencils_dp(int total, int cost1, int cost2) {
        long[] dp = new long[total + 1];
        dp[0] = 1;
        for (int j = cost1; j <= total; ++j) {
            dp[j] += dp[j - cost1];
        }
        for (int j = cost2; j <= total; ++j) {
            dp[j] += dp[j - cost2];
        }
        long ans = 0;
        for (long d : dp) {
            ans += d;
        }
        return ans;
    }

}
