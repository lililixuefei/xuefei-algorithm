package leetcode.interviewgolden;

/**
 * @description: 连续数列
 * @author: xuefei
 * @date: 2023/03/28 22:59
 */
public class MaxSubArray {

	public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < nums.length; i++) {
			dp[i] = nums[i];
			if (dp[i] < dp[i-1] + nums[i]){
				dp[i] = dp[i-1] + nums[i];
			}
			max = Math.max(max, dp[i]);
		}
		return Math.max(max, dp[0]);
	}

}
