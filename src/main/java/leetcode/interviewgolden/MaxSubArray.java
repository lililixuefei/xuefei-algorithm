package leetcode.interviewgolden;

/**
 * @description: 连续数列
 * @author: xuefei
 * @date: 2023/03/28 22:59
 */
public class MaxSubArray {

	public static void main(String[] args) {
		System.out.println(maxSubArray_2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
	}

	public static int maxSubArray_3(int[] nums) {
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] > 0) {
				nums[i] += nums[i - 1];
			}
			sum = Math.max(sum, nums[i]);
		}
		return sum;
	}

	public static int maxSubArray_2(int[] nums) {
		int sum = Integer.MIN_VALUE;
		int pre = 0;
		for (int i = 0; i < nums.length; i++) {
			int curr = nums[i];
			if (curr < pre + nums[i]) {
				curr = pre + nums[i];
			}
			pre = curr;
			sum = Math.max(sum, curr);
		}
		return sum;
	}

	public int maxSubArray_1(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < nums.length; i++) {
			dp[i] = nums[i];
			if (dp[i] < dp[i - 1] + nums[i]) {
				dp[i] = dp[i - 1] + nums[i];
			}
			max = Math.max(max, dp[i]);
		}
		return Math.max(max, dp[0]);
	}

}
