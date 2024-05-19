package leetcode.top100.sort;


/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/9 11:21 AM
 * @Version 1.0
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] nums = {5, 4, 6, 3, 1, 5, 454, 7657, 68, 3, 21};
		quickSort(nums);

		for (int num : nums) {
			System.out.println(num);
		}
	}

	public static void quickSort(int[] nums) {
		process(nums, 0, nums.length - 1);
	}

	private static void process(int[] nums, int l, int r) {
		if (l >= r) {
			return;
		}
		int i = partition(nums, l, r);
		process(nums, l, i - 1);
		process(nums, i + 1, r);
	}

	private static int partition(int[] nums, int l, int r) {
		if (l > r) {
			return -1;
		}
		if (l == r) {
			return l;
		}
		int less = l - 1;
		while (l < r) {
			if (nums[l] <= nums[r]) {
				swap(nums, ++less, l);
			}
			l++;
		}
		swap(nums, ++less, r);
		return less;
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}


}
