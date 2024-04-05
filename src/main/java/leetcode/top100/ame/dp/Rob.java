package leetcode.top100.ame.dp;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/5 19:28
 * @Version 1.0
 */
public class Rob {

	public int rob(int[] nums) {
		int n = nums.length;
		if (n < 2) {
			return nums[0];
		}
		int[] dp = new int[n];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
		}
		return dp[n - 1];
	}

}
