package leetcode.onequestion.unresolved;

/**
 * @description: 掷骰子等于目标和的方法数
 * @author: xuefei
 * @date: 2023/10/24 19:16
 */
public class NumRollsToTarget {

    static final int MOD = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        int[][] f = new int[n + 1][target + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                for (int x = 1; x <= k; x++) {
                    if (j - x >= 0) {
                        f[i][j] = (f[i][j] + f[i - 1][j - x]) % MOD;
                    }
                }
            }
        }
        return f[n][target];
    }

    public int numRollsToTarget2(int n, int k, int target) {
        int[][] f = new int[n + 1][target + 1];

        for (int i = 1; i <= k && i <= target; i++) {
            f[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                for (int x = 1; x <= k; x++) {
                    if (j - x >= 0) {
                        f[i][j] = (f[i][j] + f[i - 1][j - x]) % 1000000007;
                    }
                }
            }
        }
        return f[n][target];
    }
}
