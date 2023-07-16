package leetcode.swordfingeroffer;

/**
 * @description: 剑指 Offer 57. 和为s的两个数字
 * @author: xuefei
 * @date: 2023/07/16 19:56
 */
public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 1) {
			return new int[0];
		}
		int l = 0;
		int r = nums.length - 1;
		while (l <= r) {
			int num1 = nums[l];
			int num2 = nums[r];
			int sum = num1 + num2;
			if (sum == target) {
				return new int[]{num1, num2};
			} else if (sum > target) {
				r--;
			} else {
				l++;
			}
		}
		return new int[0];
	}

}
