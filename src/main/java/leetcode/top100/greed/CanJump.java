package leetcode.top100.greed;

/**
 * @Description 跳跃游戏
 * @Author xuefei
 * @Date 2024/3/6 23:32
 * @Version 1.0
 */
public class CanJump {

	public boolean canJump(int[] nums) {
		int n = nums.length;
		int rightmost = 0;
		for (int i = 0; i < n; ++i) {
			if (i <= rightmost) {
				rightmost = Math.max(rightmost, i + nums[i]);
				if (rightmost >= n - 1) {
					return true;
				}
			}
		}
		return false;
	}
}
