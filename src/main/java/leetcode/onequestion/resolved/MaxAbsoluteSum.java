package leetcode.onequestion.resolved;

/**
 * @description: 任意子数组和的绝对值的最大值
 * @author: xuefei
 * @date: 2023/08/08 22:42
 */
public class MaxAbsoluteSum {

    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];

        int max = f[0];
        int min = dp[0];
        for (int i = 1; i < n; i++) {
            f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
            dp[i] = Math.min(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, f[i]);
            min = Math.min(min, dp[i]);
        }
        return Math.max(Math.abs(max), Math.abs(min));
    }

}
