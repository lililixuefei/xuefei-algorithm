package leetcode.binarysearch.nodone;

/**
 * @description: 统计有序矩阵中的负数
 * @author: xuefei
 * @date: 2023/03/02 23:29
 */
public class CountNegatives {

	public int countNegatives(int[][] grid) {
		int count = 0;
		int n = grid[0].length;
		for (int[] row : grid) {
			// 二分查找第一个小于 0 的数的索引
			int first = binarySearch(row);
			count += n - first;
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1, 1, -1, -2};
		System.out.println(binarySearch(nums));
	}

	// 查找第一个小于 0 的数的索引
	private static int binarySearch(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + ((right - left) / 2);
			if (arr[mid] < 0) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}


}
