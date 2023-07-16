package leetcode.onequestion.unresolved;

/**
 * @description: 最大子序列交替和
 * @author: xuefei
 * @date: 2023/07/11 22:03
 */
public class MaxAlternatingSum {

	public static void main(String[] args) {

		int[] nums = {6, 2, 1, 2, 4, 5};
		maxAlternatingSum(nums);
	}

	public static long maxAlternatingSum(int[] nums) {
		int n = nums.length;
		long[] f = new long[n + 1];
		long[] g = new long[n + 1];
		for (int i = 1; i <= n; ++i) {
			// f[i] 表示从前 i 个元素中选出的子序列，且最后一个元素为奇数下标时的最大交替和
			f[i] = Math.max(g[i - 1] - nums[i - 1], f[i - 1]);
			// g[i] 表示从前 i 个元素中选出的子序列，且最后一个元素为偶数下标时的最大交替和
			g[i] = Math.max(f[i - 1] + nums[i - 1], g[i - 1]);
		}
		return Math.max(f[n], g[n]);
	}

}

