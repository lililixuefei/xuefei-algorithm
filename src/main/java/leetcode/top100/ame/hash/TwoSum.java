package leetcode.top100.ame.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/27 21:54
 * @Version 1.0
 */
public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int cur = target - nums[i];
			if (map.containsKey(cur)) {
				return new int[]{map.get(cur), i};
			}
			map.put(nums[i], i);
		}
		return null;
	}

}
