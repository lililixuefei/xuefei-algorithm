package labuladong.array.sum;

import java.util.Arrays;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/7/11 10:52 AM
 * @Version 1.0
 */
public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {
		Arrays.sort(nums);
		// 一左一右两个指针相向而行
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum == target) {
				// 题目要求的索引是从 1 开始的
				return new int[]{left + 1, right + 1};
			} else if (sum < target) {
				left++; // 让 sum 大一点
			} else {
				right--; // 让 sum 小一点
			}
		}
		return new int[]{-1, -1};
	}

}
