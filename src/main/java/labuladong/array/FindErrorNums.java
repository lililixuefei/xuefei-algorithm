package labuladong.array;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/7/11 10:32 AM
 * @Version 1.0
 */
public class FindErrorNums {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 5};
		findErrorNums(nums);
	}


	public static int[] findErrorNums(int[] nums) {
		int n = nums.length;
		int dup = -1;
		for (int i = 0; i < n; i++) {
			int index = Math.abs(nums[i]) - 1;
			// nums[index] 小于 0 则说明重复访问
			if (nums[index] < 0) {
				dup = Math.abs(nums[i]);
			} else {
				nums[index] *= -1;
			}
		}

		int missing = -1;
		for (int i = 0; i < n; i++) {
			// nums[i] 大于 0 则说明没有访问
			if (nums[i] > 0) {
				missing = i + 1;
			}
		}
		return new int[]{dup, missing};
	}

}
