package leetcode.top100.dp;

import java.util.Arrays;

/**
 * @Description 完全平方数
 * @Author xuefei
 * @Date 2023/12/24 15:08
 * @Version 1.0
 */
public class NumSquares {

	public static void main(String[] args) {
		System.out.println(numSquares(3));
	}


	public static int numSquares(int n) {
		// 定义：和为 i 的平方数的最小数量是 dp[i]
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		// base case
		dp[0] = 0;
		// 状态转移方程
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				// i - j * j 只要再加一个平方数 j * j 即可凑出 i
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		return dp[n];
	}

}
