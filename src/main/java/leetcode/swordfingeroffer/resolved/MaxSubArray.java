package leetcode.swordfingeroffer.resolved;

/**
 * @description: 剑指 Offer 42. 连续子数组的最大和
 * @author: xuefei
 * @date: 2023/07/25 23:21
 */
public class MaxSubArray {

	public static void main(String[] args) {
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		maxSubArray(nums);
	}

	public static int maxSubArray(int[] nums) {
		if (nums == null || nums.length < 1) {
			return 0;
		}
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = nums[0];
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
		}
		int value = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			value = Math.max(value, dp[i]);
		}
		return value;
	}

	public static int maxSubArray2(int[] nums) {
		if (nums == null || nums.length < 1) {
			return 0;
		}
		int n = nums.length;
		int value = Integer.MIN_VALUE;
		int preValue = 0;
		int curValue;
		for (int i = 0; i < n; i++) {
			curValue = Math.max(preValue + nums[i], nums[i]);
			preValue = curValue;
			value = Math.max(value, curValue);
		}
		return value;
	}

}
