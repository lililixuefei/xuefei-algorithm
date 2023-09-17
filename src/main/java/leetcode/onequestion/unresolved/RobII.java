package leetcode.onequestion.unresolved;


/**
 * @Description 打家劫舍 II
 * @Author xuefei
 * @Date 2023/9/17 13:00
 * @Version 1.0
 */
public class RobII {


    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));

    }

    int robRange3(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);
        int value = second;
        for (int i = 2; i < end - start + 1; i++) {
            value = Math.max((nums[start + i] + first), second);
            first = second;
            second = value;
        }
        return value;
    }

    int robRange2(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int[] dp = new int[end - start + 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < end - start + 1; i++) {
            dp[i] = Math.max((nums[start + i] + dp[i - 2]), dp[i - 1]);
        }
        return dp[end - start];
    }


    // 仅计算闭区间 [start,end] 的最优结果
    int robRange(int[] nums, int start, int end) {
        int dp_i_1 = 0;
        int dp_i = 0;
        int dp_i_2 = 0;
        for (int i = end; i >= start; i--) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }

}
