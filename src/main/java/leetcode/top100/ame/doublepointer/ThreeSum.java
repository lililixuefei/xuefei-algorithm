package leetcode.top100.ame.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/27 22:31
 * @Version 1.0
 */
public class ThreeSum {


	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			List<List<Integer>> curAns = twoSum(nums, i + 1, -nums[i]);
			for (List<Integer> cur : curAns) {
				cur.add(nums[i]);
				ans.add(cur);
			}
			while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
				i++;
			}
		}
		return ans;
	}

	private static List<List<Integer>> twoSum(int[] nums, int i, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		int left = i;
		int right = nums.length - 1;
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum > target) {
				right--;
			} else if (sum < target) {
				left++;
			} else {
				if (left == i || nums[left - 1] != nums[left]) {
					List<Integer> curAns = new ArrayList<>();
					curAns.add(nums[left]);
					curAns.add(nums[right]);
					ans.add(curAns);
				}
				left++;
			}
		}
		return ans;
	}

}
