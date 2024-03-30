package leetcode.top100.ame.dp;

import java.util.Arrays;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/30 17:50
 * @Version 1.0
 */
public class LengthOfLIS {

	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int ans = 1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					ans = Math.max(dp[i], ans);
				}
			}
		}
		return ans;
	}

}
