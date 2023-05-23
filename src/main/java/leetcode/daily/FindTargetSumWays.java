package leetcode.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 目标和
 * @author: xuefei
 * @date: 2023/05/23 22:42
 */
public class FindTargetSumWays {

	public int findTargetSumWays(int[] nums, int target) {
		return process(nums, 0, target, new HashMap<>());
	}

	private int process(int[] nums, int i, int target, Map<Integer, Map<Integer, Integer>> dp) {
		if (dp.containsKey(i) && dp.get(i).containsKey(target)) {
			return dp.get(i).get(target);
		}
		int ans;
		if (i == nums.length) {
			ans = target == 0 ? 1 : 0;
		} else {
			ans = process(nums, i + 1, target - nums[i], dp) + process(nums, i + 1, target + nums[i], dp);
		}
		if (!dp.containsKey(i)) {
			dp.put(i, new HashMap<>());
		}
		dp.get(i).put(target, ans);
		return ans;
	}

}
