package leetcode.doublepointer.nodone;

/**
 * @description: 按奇偶排序数组 II
 * @author: xuefei
 * @date: 2023/03/01 22:47
 */
public class SortArrayByParityII {


	public int[] sortArrayByParityII(int[] nums) {
		int n = nums.length;
		int j = 1;
		for (int i = 0; i < n; i += 2) {
			if (nums[i] % 2 == 1) {
				while (nums[j] % 2 == 1) {
					j += 2;
				}
				swap(nums, i, j);
			}
		}
		return nums;
	}


	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
