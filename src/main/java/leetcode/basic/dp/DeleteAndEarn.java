package leetcode.basic.dp;

/**
 * @description: 删除并获得点数
 * @author: xuefei
 * @date: 2023/05/29 00:02
 */
public class DeleteAndEarn {


	public int deleteAndEarn(int[] nums) {
		int maxVal = 0;
		for (int val : nums) {
			maxVal = Math.max(maxVal, val);
		}
		int[] sum = new int[maxVal + 1];
		for (int val : nums) {
			sum[val] += val;
		}
		return rob(sum);
	}

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

	public int rob2(int[] nums) {
		int size = nums.length;
		int first = nums[0];
		int second = Math.max(nums[0], nums[1]);
		for (int i = 2; i < size; i++) {
			int temp = second;
			second = Math.max(first + nums[i], second);
			first = temp;
		}
		return second;
	}

}
