package leetcode.top100.ame.dp;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/5 18:48
 * @Version 1.0
 */
public class ClimbStairs {


	public int climbStairs2(int n) {
		if (n < 2) {
			return n;
		}
		if (n == 2) {
			return 2;
		}
		int p = 1;
		int m = 2;
		int ans = 0;
		for (int i = 3; i <= n; i++) {
			ans = p + m;
			p = m;
			m = ans;
		}
		return ans;
	}

	public int climbStairs(int n) {
		if (n < 2) {
			return n;
		}
		if (n == 2) {
			return 2;
		}
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

}
