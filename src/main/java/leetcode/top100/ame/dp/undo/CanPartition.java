package leetcode.top100.ame.dp.undo;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/5 19:43
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

		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j - nums[i - 1] < 0) {
					// 背包容量不足，不能装入第 i 个物品
					dp[i][j] = dp[i - 1][j];
				} else {
					// 装入或不装入背包
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
				}
			}
		}
		return dp[n][sum];
	}

}
