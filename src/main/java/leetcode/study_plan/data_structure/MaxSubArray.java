package leetcode.study_plan.data_structure;

/**
 * @description: 最大子数组和   https://leetcode.cn/problems/maximum-subarray/
 * @author: xuefei
 * @date: 2022/05/14 17:29
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public int maxSubArrayDp(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int maxNum = dp[0];

        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1] > 0){
                dp[i] = nums[i] + dp[i-1];
            }else {
                dp[i] = nums[i];
            }

            if (maxNum < dp[i]){
                maxNum = dp[i];
            }

        }
        return maxNum;
    }


}
