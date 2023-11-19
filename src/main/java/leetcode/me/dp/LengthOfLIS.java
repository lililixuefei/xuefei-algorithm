package leetcode.me.dp;

import java.util.Arrays;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/11/19 16:56
 * @Version 1.0
 */
public class LengthOfLIS {


	public static int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], 1 + dp[j]);
					ans = Math.max(dp[i], ans);
				}
			}
		}
		return ans == Integer.MIN_VALUE ? 1 : ans;
	}


}
