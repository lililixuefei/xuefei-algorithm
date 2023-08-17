package leetcode.onequestion.unresolved;

/**
 * @description: 切披萨的方案数
 * @author: xuefei
 * @date: 2023/08/17 22:19
 */
public class Ways {


    int n, m;
    String[] pizza;
    int MOD = (int) (1e9 + 7);
    long[][][] dp;

    public int ways(String[] _pizza, int k) {
        pizza = _pizza;
        n = pizza.length;
        m = pizza[0].length();
        dp = new long[n][m][10];
        return (int) dfs(0, n - 1, 0, m - 1, k - 1);
    }

    public long dfs(int si, int ei, int sj, int ej, int t) {
        if (si > ei || sj > ej) {
            return 0;
        }
        if (t == 0) {
            return check(si, ei, sj, ej) ? 1 : 0;
        }
        if (dp[si][sj][t] != 0) {
            return dp[si][sj][t];
        }
        long ans = 0;
        for (int i = si; i <= ei; i++) {
            if (check(si, i, sj, ej)) {
                ans += dfs(i + 1, ei, sj, ej, t - 1) % MOD;
            }
        }
        for (int j = sj; j <= ej; j++) {
            if (check(si, ei, sj, j)) {
                ans += dfs(si, ei, j + 1, ej, t - 1) % MOD;
            }
        }
        dp[si][sj][t] = ans;
        return ans % MOD;
    }

    public boolean check(int si, int ei, int sj, int ej) {
        for (int i = si; i <= ei; i++) {
            for (int j = sj; j <= ej; j++) {
                if (pizza[i].charAt(j) == 'A') {
                    return true;
                }
            }
        }
        return false;
    }

}
