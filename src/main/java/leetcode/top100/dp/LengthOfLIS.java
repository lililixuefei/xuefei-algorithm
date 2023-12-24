package leetcode.top100.dp;

import java.util.Arrays;

/**
 * @Description 最长递增子序列
 * @Author xuefei
 * @Date 2023/12/24 15:33
 * @Version 1.0
 */
public class LengthOfLIS {

	public int lengthOfLIS(int[] nums) {
		// dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
		int[] dp = new int[nums.length];
		// base case：dp 数组全都初始化为 1
		Arrays.fill(dp, 1);
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int res = 0;
		for (int i = 0; i < dp.length; i++) {
			res = Math.max(res, dp[i]);
		}
		return res;
	}

}
