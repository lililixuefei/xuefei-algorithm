package leetcode.onequestion.resolved;

/**
 * @description: 下降路径最小和 II
 * @author: xuefei
 * @date: 2023/08/10 23:03
 */
public class MinFallingPathSum2 {

    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int m = 0; m < n; m++) {
                    if (j == m) {
                        continue;
                    }

                    dp[i][j] = Math.min(dp[i][j], grid[i][j] + dp[i - 1][m]);
                }
            }
        }

        int minFallingPathSum = Integer.MAX_VALUE;
        for (int i : dp[n - 1]) {
            minFallingPathSum = Math.min(minFallingPathSum, i);
        }

        return minFallingPathSum;
    }

}
