package leetcode.top100.greed;

/**
 * @Description 跳跃游戏 II
 * @Author xuefei
 * @Date 2024/3/6 23:37
 * @Version 1.0
 */
public class Jump {

	public int jump(int[] nums) {
		int n = nums.length;
		int end = 0, farthest = 0;
		int jumps = 0;
		for (int i = 0; i < n - 1; i++) {
			farthest = Math.max(nums[i] + i, farthest);
			// 如果当前位置等于 end，则说明已经跳跃到了当前可以到达的最远位置，需要进行一次新的跳跃
			if (end == i) {
				jumps++;
				end = farthest;
			}
		}
		return jumps;
	}

}
