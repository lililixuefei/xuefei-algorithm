package leetcode.swordfingeroffer.unresolved;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 剑指 Offer 03. 数组中重复的数字
 * @author: xuefei
 * @date: 2023/07/16 20:43
 */
public class FindRepeatNumber {

	/**
	 * wrong
	 * @param nums
	 * @return
	 */
	public int findRepeatNumber3(int[] nums) {
		for (int num : nums) {
			if (nums[Math.abs(num)] < 0) {
				// 之前已经把对应索引的元素变成负数了，
				// 这说明 num 重复出现了两次
				return Math.abs(num);
			} else {
				// 把索引 num 的元素置为负数
				nums[Math.abs(num)] *= -1;
			}
		}
		// 如果没有在 for 循环中返回，说明重复的那个元素是 0
		return 0;
	}

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
