package leetcode.basic.slidingwindow;

/**
 * @description: 最大连续1的个数 III
 * @author: xuefei
 * @date: 2023/03/22 22:54
 */
public class LongestOnes {

	public static void main(String[] args) {
		LongestOnes longestOnes = new LongestOnes();
		int[] nums = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
		longestOnes.longestOnes(nums, 2);

	}

	public int longestOnes(int[] nums, int k) {
		int left = 0;
		int right = 0;
		int zeros = 0;
		int res = Integer.MIN_VALUE;
		while (right < nums.length) {
			if (nums[right] == 0) {
				zeros++;
			}
			while (zeros > k) {
				if (nums[left] == 0) {
					zeros--;
				}
				left++;
			}
			res = Math.max(res, right - left + 1);
			right++;
		}
		return res;
	}

}
