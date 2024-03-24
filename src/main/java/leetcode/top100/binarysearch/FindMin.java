package leetcode.top100.binarysearch;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/24 20:13
 * @Version 1.0
 */
public class FindMin {

	public int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			int pivot = low + (high - low) / 2;
			if (nums[pivot] < nums[high]) {
				high = pivot;
			} else {
				low = pivot + 1;
			}
		}
		return nums[low];
	}

}
