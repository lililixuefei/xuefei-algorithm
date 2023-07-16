package leetcode.swordfingeroffer.done;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 数组中重复的数字
 * @author: xuefei
 * @date: 2023/03/05 22:42
 */
public class FindRepeatNumber {

	public int findRepeatNumber(int[] nums) {
		if (nums == null || nums.length < 1) {
			return -1;
		}
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] != i) {
				if (nums[i] == nums[nums[i]]) {
					return nums[i];
				}
				swap(nums, i, nums[i]);
			}
		}
		return -1;
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public int findRepeatNumber_me(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (set.contains(num)) {
				return num;
			}
			set.add(num);
		}
		return -1;
	}

}
