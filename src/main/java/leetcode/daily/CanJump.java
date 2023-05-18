package leetcode.daily;

/**
 * @description: 跳跃游戏
 * @author: xuefei
 * @date: 2023/05/18 22:09
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
