package leetcode.binarysearch.nodone;

/**
 * @description: 查找插入位置
 * @author: xuefei
 * @date: 2023/03/03 23:05
 */
public class SearchInsert {

	public static void main(String[] args) {
		int[] nums = new int[]{1, 3, 5, 6};
		System.out.println(searchInsert(nums, 2));
	}

	public static int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

}
