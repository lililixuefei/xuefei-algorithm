package dp;

/**
 * @description: 最大子数组和   https://leetcode.cn/problems/maximum-subarray/
 * @author: xuefei
 * @date: 2022/07/06 01:19
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        // nums = [-2,1,-3,4,-1,2,1,-5,4]
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSub = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = nums[i] + dp[i - 1];
            } else {
                dp[i] = nums[i];
            }
            maxSub = Math.max(maxSub, dp[i]);
        }
        return maxSub;
    }
}
