package leetcode.basic.dp;

/**
 * @description: 打家劫舍
 * @author: xuefei
 * @date: 2023/05/28 13:28
 */
public class Rob {

	public int rob(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}

		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
		}
		return dp[nums.length - 1];
	}


	public int process(int[] nums, int i, int[] dp) {
		if (i >= nums.length) {
			return 0;
		}
		if (dp[i] != 0) {
			return dp[i];
		}

		// 偷
		int ans1 = process(nums, i + 2, dp) + nums[i];

		// 不偷
		int ans2 = process(nums, i + 1, dp);

		dp[i] = Math.max(ans1, ans2);

		return dp[i];

	}


}
