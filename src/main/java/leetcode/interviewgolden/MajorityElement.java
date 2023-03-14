package leetcode.interviewgolden;

import java.util.Arrays;

/**
 * @description: 主要元素
 * @author: xuefei
 * @date: 2023/03/14 23:34
 */
public class MajorityElement {

	public int majorityElement(int[] nums) {
		if (nums.length < 2) {
			return nums[0];
		}
		Arrays.sort(nums);
		int count = 1;
		int mid = nums.length / 2;
		for (int i = mid - 1; i >= 0; i--) {
			if (nums[i] == nums[mid]) {
				count++;
			}
		}
		for (int i = mid + 1; i < nums.length; i++) {
			if (nums[i] == nums[mid]) {
				count++;
			}
		}
		return count > mid ? nums[mid] : -1;
	}
}
