package leetcode.top100.dp.houserobber;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/6/25 2:37 PM
 * @Version 1.0
 */
public class Rob1 {

	public static void main(String[] args) {
		int[] nums = {2, 7, 9, 3, 1};
		System.out.println(rob(nums));
		System.out.println(rob_2(nums));
	}


	// 主函数
	public int rob_1(int[] nums) {
		return dp(nums, 0);
	}

	// 返回 nums[start..] 能抢到的最大值
	private int dp(int[] nums, int start) {
		if (start >= nums.length) {
			return 0;
		}

		int res = Math.max(
				// 不抢，去下家
				dp(nums, start + 1),
				// 抢，去下下家
				nums[start] + dp(nums, start + 2)
		);
		return res;
	}

	public static int rob(int[] nums) {
		int n = nums.length;
		// dp[i] = x 表示：
		// 从第 i 间房子开始抢劫，最多能抢到的钱为 x
		// base case: dp[n] = 0
		int[] dp = new int[n + 2];
		for (int i = n - 1; i >= 0; i--) {
			dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
		}
		return dp[0];
	}

	public static int rob_2(int[] nums) {
		int n = nums.length;

		int[] dp = new int[n];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}
		return dp[n - 1];
	}

}
