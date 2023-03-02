package leetcode.binarysearch;

/**
 * @description: 二分查找
 * @author: xuefei
 * @date: 2023/03/02 23:51
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] nums = new int[]{-2, -1, 1, 1};
		System.out.println(binarySearch(nums, -1));
	}

	private static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

}
