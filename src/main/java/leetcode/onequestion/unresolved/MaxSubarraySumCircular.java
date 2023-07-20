package leetcode.onequestion.unresolved;

/**
 * @description: 环形子数组的最大和
 * @author: xuefei
 * @date: 2023/07/20 21:50
 */
public class MaxSubarraySumCircular {

	public int maxSubarraySumCircular(int[] nums) {
		int total = 0;
		int maxSum = nums[0];
		int curMaxSum = 0;
		int minSum = nums[0];
		int curMinSum = 0;
		for (int num : nums) {
			curMaxSum = Math.max(num, num + curMaxSum);
			maxSum = Math.max(maxSum, curMaxSum);
			curMinSum = Math.min(num, num + curMinSum);
			minSum = Math.min(minSum, curMinSum);
			total += num;
		}
		return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
	}

}
