package leetcode.basic.array;

/**
 * @description: 删除有序数组中的重复项
 * @author: xuefei
 * @date: 2023/05/08 23:05
 */
public class RemoveDuplicates {

	public int removeDuplicates(int[] nums) {
		if (nums.length == 1){
			return 1;
		}
		int l = 0;
		int r = 1;
		while (r < nums.length){
			if (nums[l] != nums[r]) {
				l++;
				swap(nums, l, r);
			}
			r++;
		}
		return l+1;
	}

	private void swap(int[] nums, int l, int r) {
		int temp = nums[l];
		nums[l] = nums[r];
		nums[r] = temp;
	}

}
