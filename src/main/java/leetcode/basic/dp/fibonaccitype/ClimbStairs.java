package leetcode.basic.dp.fibonaccitype;

/**
 * @description: 爬楼梯
 * @author: xuefei
 * @date: 2023/05/26 00:13
 */
public class ClimbStairs {

	public int climbStairs(int n) {
		return process3(n);
	}


	public int climbStairs2(int n) {
		int p = 0;
		int q = 0;
		int r = 1;
		for (int i = 1; i <= n; ++i) {
			p = q;
			q = r;
			r = p + q;
		}
		return r;
	}


	private int process3(int n) {
		if (n <= 2) {
			return n;
		}
		int cur = 2;
		int pre = 1;
		int ans = 0;
		for (int i = 2; i < n; i++) {
			ans = cur + pre;
			pre = cur;
			cur = ans;
		}
		return ans;
	}

	private int process2(int n) {
		if (n <= 2) {
			return n;
		}
		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 2;

		for (int i = 2; i < n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n - 1];
	}

	private int process1(int n) {
		if (n <= 2) {
			return n;
		}
		return process1(n - 1) + process1(n - 2);
	}

}
