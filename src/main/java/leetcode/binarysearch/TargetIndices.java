package leetcode.binarysearch;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 找出数组排序后的目标下标
 * @author: xuefei
 * @date: 2023/03/03 23:48
 */
public class TargetIndices {

	public List<Integer> targetIndices(int[] nums, int target) {
		Arrays.sort(nums);

		int left = leftMostSearch(nums, target);
		int right = rightMostSearch(nums, target);
		List<Integer> list = new ArrayList<>();

		if (left != -1 && right != -1) {
			while (left <= right){
				list.add(left++);
			}
		}
		return list;
	}

	private int rightMostSearch_2(int[] nums, int target) {
		int i = 0;
		int j = nums.length - 1;
		while (i <= j) {
			int mid = i + (j - i) / 2;
			if (nums[mid] == target) {
				i = mid + 1;
			}else if (nums[mid] > target){
				j = mid - 1;
			}else {
				i = mid + 1;
			}
		}
		if(i - 1 < 0){
			return - 1;
		}
		return nums[i - 1] == target ? i - 1  : -1;
	}

	private int rightMostSearch(int[] nums, int target) {
		int i = 0;
		int j = nums.length - 1;
		while (i <= j) {
			int mid = i + (j - i) / 2;
			if (nums[mid] > target) {
				j = mid - 1;
			} else {
				i = mid + 1;
			}
		}
		if(i - 1 < 0){
			return - 1;
		}
		return nums[i - 1] == target ? i - 1  : -1;
	}

	private int leftMostSearch(int[] nums, int target) {
		int i = 0;
		int j = nums.length - 1;
		while (i <= j) {
			int mid = i + (j - i) / 2;
			if (nums[mid] < target) {
				i = mid + 1;
			} else {
				j = mid - 1;
			}
		}
		if (i >= nums.length){
			return -1;
		}
		return nums[i] == target ? i : -1;
	}


}
