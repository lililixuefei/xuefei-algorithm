package leetcode.swordfingeroffer;

import java.util.Arrays;

/**
 * @description: 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * @author: xuefei
 * @date: 2023/07/17 23:06
 */
public class MissingNumber {

	public int missingNumber2(int[] nums) {
		// 搜索左侧的二分搜索
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > mid) {
				// mid 和 nums[mid] 不对应，说明左边有元素缺失
				right = mid - 1;
			} else {
				// mid 和 nums[mid] 对应，说明元素缺失在右边
				left = mid + 1;
			}
		}
		return left;
	}


}
