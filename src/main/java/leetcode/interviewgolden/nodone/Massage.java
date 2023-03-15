package leetcode.interviewgolden.nodone;

/**
 * @description: 按摩师
 * @author: xuefei
 * @date: 2023/03/15 22:54
 */
public class Massage {

	public static void main(String[] args) {
		int[] nums = new int[]{2, 1, 4, 5, 3, 1, 1, 3};
		Massage massage = new Massage();
		massage.massage(nums);
	}

	public int massage(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		int max = dp[1];
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
