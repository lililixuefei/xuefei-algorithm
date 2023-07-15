package leetcode.onequestion.unresolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/07/16 00:15
 */
public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<>();

		int n = nums.length;

		for (int i = 0; i < n; i++) {
			List<List<Integer>> tuples = twoSum(nums, i + 1, -nums[i]);
			for (List<Integer> tuple : tuples) {
				tuple.add(nums[i]);
				ans.add(tuple);
			}
			// 跳过第一个数字重复的情况，否则会出现重复结果
			while (i < n - 1 && nums[i] == nums[i + 1]) {
				i++;
			}
		}

		return ans;
	}

	public List<List<Integer>> twoSum(int[] nums, int start, long target) {
		int L = start;
		int R = nums.length - 1;
		List<List<Integer>> ans = new ArrayList<>();
		while (L < R) {
			if (nums[L] + nums[R] > target) {
				R--;
			} else if (nums[L] + nums[R] < target) {
				L++;
			} else { // nums[L] + nums[R] == target
				if (L == start || nums[L - 1] != nums[L]) {
					List<Integer> cur = new ArrayList<>();
					cur.add(nums[L]);
					cur.add(nums[R]);
					ans.add(cur);
				}
				L++;
			}
		}
		return ans;
	}

}
