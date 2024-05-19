package leetcode.top100.sort;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/7 3:33 PM
 * @Version 1.0
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] nums = {5, 4, 6, 3, 1, 5, 454, 7657, 68, 3, 21};
		mergeSort(nums);

		for (int num : nums) {
			System.out.println(num);
		}
	}

	public static void mergeSort(int[] nums) {
		process(nums, 0, nums.length - 1);
	}

	public static void process(int[] nums, int l, int r) {
		if (l >= r) {
			return;
		}
		int mid = l + (r - l) / 2;
		process(nums, l, mid);
		process(nums, mid + 1, r);
		mergeSort(nums, l, mid, r);
	}

	private static void mergeSort(int[] nums, int l, int mid, int r) {
		int[] array = new int[r - l + 1];
		int i = 0;
		int t = l;
		int m = mid + 1;
		while (t <= mid && m <= r) {
			array[i++] = nums[t] <= nums[m] ? nums[t++] : nums[m++];
		}
		while (t <= mid) {
			array[i++] = nums[t++];
		}
		while (m <= r) {
			array[i++] = nums[m++];
		}
		for (int j = 0; j < array.length; j++) {
			nums[l + j] = array[j];
		}
	}


}
