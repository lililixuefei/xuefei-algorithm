package leetcode.top100.me;

/**
 * @description:
 * @author: xuefei
 * @date: 2024/03/27 19:31
 */
public class MaxSubArray {


    public int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i] + nums[i]);
            ans = Math.max(nums[i], ans);
        }
        return ans;
    }

}
