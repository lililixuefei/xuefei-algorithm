package labuladong.dp.houserobber;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/6/25 2:48 PM
 * @Version 1.0
 */
public class Rob2 {

	public int rob(int[] nums) {
		int n = nums.length;
		if (n == 1) {
			return nums[0];
		}
		return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
	}

	// 仅计算闭区间 [start,end] 的最优结果
	int robRange(int[] nums, int start, int end) {
		int n = nums.length;
		int dp_i_1 = 0, dp_i_2 = 0;
		int dp_i = 0;
		for (int i = end; i >= start; i--) {
			dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
			dp_i_2 = dp_i_1;
			dp_i_1 = dp_i;
		}
		return dp_i;
	}

	public static int rob_2(int[] nums, int start, int end) {
		int n = end - start + 1;

		int[] dp = new int[n];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);

		for (int i = start; i < end; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}
		return dp[n - 1];
	}

}
