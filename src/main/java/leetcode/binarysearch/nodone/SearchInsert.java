package leetcode.binarysearch.nodone;

/**
 * @description: 查找插入位置
 * @author: xuefei
 * @date: 2023/03/03 23:05
 */
public class SearchInsert {

	public static void main(String[] args) {
		int[] nums = new int[]{1, 3, 5};
		System.out.println(searchInsert(nums, 3));
	}

	public static int searchInsert(int[] nums, int target) {
		int i = 0;
		int j = nums.length - 1;
		while (i <= j) {
			int mid = i + (j - i) / 2;
			if (nums[mid] == target) {
				j = mid - 1;
			} else if (nums[mid] > target) {
				j = mid - 1;
			} else {
				i = mid + 1;
			}
		}
		return i;
	}

}
