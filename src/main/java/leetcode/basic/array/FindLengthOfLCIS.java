package leetcode.basic.array;

/**
 * @description: 最长连续递增序列
 * @author: xuefei
 * @date: 2023/05/05 22:57
 */
public class FindLengthOfLCIS {

	public static void main(String[] args) {
		int[] nums = {1, 3, 5, 4, 7};
		System.out.println(findLengthOfLCIS(nums));
	}

	public static int findLengthOfLCIS(int[] nums) {
		if (nums.length < 2) {
			return nums[0];
		}
		int length = 0;
		int l = 0;
		int r = 1;
		while (r < nums.length) {
			if (nums[r] <= nums[r - 1]) {
				l = r;
			}
			r++;
			length = Math.max(length, r - l);
		}
		return length;
	}

}
