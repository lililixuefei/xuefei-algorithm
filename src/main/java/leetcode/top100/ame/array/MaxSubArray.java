package leetcode.top100.ame.array;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/30 19:35
 * @Version 1.0
 */
public class MaxSubArray {

	public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int ans = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
			ans = Math.max(ans, dp[i]);
		}
		return ans;
	}

}
