package leetcode.binarysearch.nodone;

/**
 * @description: 正整数和负整数的最大计数
 * @author: xuefei
 * @date: 2023/03/02 23:07
 */
public class MaximumCount {


	public int maximumCount(int[] nums) {
		// 二分搜索：正数：递增排序 > 0 左边界
		// 二分搜索：负数：递增排序 < 0 右边界
		int zIndex = getZ(nums);
		int fIndex = getF(nums);
		return Math.max(nums.length - zIndex, fIndex + 1);

	}

	int getZ(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] <= 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

	int getF(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return right;
	}

}
