package leetcode.swordfingeroffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 剑指 Offer 03. 数组中重复的数字
 * @author: xuefei
 * @date: 2023/07/16 20:43
 */
public class FindRepeatNumber {

	public int findRepeatNumber2(int[] nums) {
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

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}


	public int findRepeatNumber(int[] nums) {
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
