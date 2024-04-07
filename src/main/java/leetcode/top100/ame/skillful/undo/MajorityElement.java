package leetcode.top100.ame.skillful.undo;

import java.util.Arrays;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/7 23:08
 * @Version 1.0
 */
public class MajorityElement {

	public int majorityElement(int[] nums) {
		// 我们想寻找的那个众数
		int target = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (count == 0) {
				// 当计数器为 0 时，假设 nums[i] 就是众数
				target = nums[i];
				// 众数出现了一次
				count = 1;
			} else if (nums[i] == target) {
				// 如果遇到的是目标众数，计数器累加
				count++;
			} else {
				// 如果遇到的不是目标众数，计数器递减
				count--;
			}
		}
		return target;
	}
}
