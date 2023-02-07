package labuladong.dp;

import java.util.Arrays;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/02/07 22:42
 */
public class MinFallingPathSum {

    /**
     * 备忘录
     */
    int[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        // 备忘录里的值初始化为 66666
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], 66666);
        }
        // 终点可能在 matrix[n-1] 的任意一列
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp(matrix, n - 1, j));
        }
        return res;
    }


    int dp(int[][] matrix, int i, int j) {
        // 1、索引合法性检查
        if (i < 0 || j < 0 ||
                i >= matrix.length ||
                j >= matrix[0].length) {

            return 99999;
        }
        // 2、base case
        if (i == 0) {
            return matrix[0][j];
        }
        // 3、查找备忘录，防止重复计算
        if (memo[i][j] != 66666) {
            return memo[i][j];
        }
        // 进行状态转移
        memo[i][j] = matrix[i][j] + min(
                dp(matrix, i - 1, j),
                dp(matrix, i - 1, j - 1),
                dp(matrix, i - 1, j + 1)
        );

        return memo[i][j];
    }


    public int minFallingPathSum2(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;

        // 终点可能在最后一行的任意一列
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp2(matrix, n - 1, j));
        }

        return res;
    }

    int dp2(int[][] matrix, int i, int j) {
        // 非法索引检查
        if (i < 0 || j < 0 ||
                i >= matrix.length ||
                j >= matrix[0].length) {
            // 返回一个特殊值
            return 99999;
        }
        // base case
        if (i == 0) {
            return matrix[i][j];
        }
        // 状态转移
        return matrix[i][j] + min(
                dp2(matrix, i - 1, j),
                dp2(matrix, i - 1, j - 1),
                dp2(matrix, i - 1, j + 1)
        );
    }

    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
