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
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				list.add(i);
			}
		}
		return list;
	}


}
