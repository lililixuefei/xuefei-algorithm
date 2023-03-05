package leetcode.basic.doublepointer;

/**
 * @description: 按奇偶排序数组
 * @author: xuefei
 * @date: 2023/03/01 22:39
 */
public class SortArrayByParity {

	public int[] sortArrayByParity(int[] nums) {
		int i = 0;
		int j = nums.length - 1;

		while (i < j){
			int numI = nums[i];
			if (numI % 2 == 0){
				i++;
			}else {
				swap(nums,i,j);
				j--;
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
