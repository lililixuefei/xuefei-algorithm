package leetcode.basic.slidingwindow;

import java.util.Arrays;

/**
 * @description: 学生分数的最小差值
 * @author: xuefei
 * @date: 2023/03/21 22:18
 */
public class MinimumDifference {

	public int minimumDifference(int[] nums, int k) {
		if (k == 1) {
			return 0;
		}
		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int j = i + k - 1;
			if (j >= nums.length) {
				break;
			}
			int cur = nums[j] - nums[i];
			min = Math.min(min, cur);
		}
		return min;
	}

}
