package leetcode.basic.doublepointer;

import java.util.Arrays;

/**
 * @description: 有序数组的平方
 * @author: xuefei
 * @date: 2023/03/01 23:17
 */
public class SortedSquares {

	public int[] sortedSquares_good(int[] nums) {
		int n = nums.length;
		int[] ans = new int[n];
		for (int i = 0, j = n - 1, pos = n - 1; i <= j; ) {
			if (nums[i] * nums[i] > nums[j] * nums[j]) {
				ans[pos] = nums[i] * nums[i];
				++i;
			} else {
				ans[pos] = nums[j] * nums[j];
				--j;
			}
			--pos;
		}
		return ans;
	}

	public int[] sortedSquares_me(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] * nums[i];
		}
		Arrays.sort(nums);
		return nums;
	}

}
