package leetcode.binarysearch.nodone;

/**
 * @description: 统计有序矩阵中的负数
 * @author: xuefei
 * @date: 2023/03/02 23:29
 */
public class CountNegatives {

	public int countNegatives(int[][] grid) {
		int count = 0;
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 0; i < m; i++) {
			int[] row = grid[i];
			if (row[n - 1] >= 0) {
				continue;
			}
			if (row[0] < 0) {
				count += (m - i) * n;
				break;
			}
			// 当前行二分查找第一个小于 0 的数的索引
			int first = binarySearch(row);
			count += n - first;
		}
		return count;
	}

	// 查找第一个小于 0 的数的索引
	private int binarySearch(int[] arr) {
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
