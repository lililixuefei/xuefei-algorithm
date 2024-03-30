package leetcode.top100.ame.doublepointer;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/27 22:11
 * @Version 1.0
 */
public class MoveZeroes {

	public void moveZeroes(int[] nums) {
		int left = 0;
		int right = 0;
		while (right < nums.length) {
			if (nums[right] != 0) {
				swap(nums, left, right);
				left++;
			}
			right++;
		}

	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
