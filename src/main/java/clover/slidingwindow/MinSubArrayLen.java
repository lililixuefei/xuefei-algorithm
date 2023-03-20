package clover.slidingwindow;

/**
 * @description: 和大于等于 target 的最短子数组
 * @author: xuefei
 * @date: 2023/03/20 22:53
 */
public class MinSubArrayLen {

	public int minSubArrayLen(int s, int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}
		int ans = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		int sum = 0;
		while (end < n) {
			sum += nums[end];
			while (sum >= s) {
				ans = Math.min(ans, end - start + 1);
				sum -= nums[start];
				start++;
			}
			end++;
		}
		return ans == Integer.MAX_VALUE ? 0 : ans;
	}

}
