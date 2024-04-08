package leetcode.top100.ame.dp;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/8 22:28
 * @Version 1.0
 */
public class CanPartition {

	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % 2 != 0) {
			return false;
		}
		sum = sum / 2;
		int n = nums.length;
		boolean[][] dp = new boolean[n + 1][sum + 1];
		for (int i = 0; i <= n; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j >= nums[i - 1]) {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][sum];
	}


}
