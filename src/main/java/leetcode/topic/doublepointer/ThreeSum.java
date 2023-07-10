package leetcode.topic.doublepointer;

import java.util.*;

/**
 * @description: 三数之和
 * @author: xuefei
 * @date: 2023/07/10 22:38
 */
public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			int target = -num;

			List<Integer> twoSum = twoSum(nums, i + 1, target);
			if (twoSum.size() == 0) {
				continue;
			}
			twoSum.add(num);
			res.add(twoSum);
		}
		return res;
	}


	public List<Integer> twoSum(int[] nums, int i, int target) {
		List<Integer> ans = new ArrayList<>();
		Map<Integer, Integer> hashtable = new HashMap<>();
		for (; i < nums.length; ++i) {
			if (hashtable.containsKey(target - nums[i])) {
				ans.add(nums[hashtable.get(target - nums[i])]);
				ans.add(nums[i]);
				return ans;
			}
			hashtable.put(nums[i], i);
		}
		return ans;
	}

}
