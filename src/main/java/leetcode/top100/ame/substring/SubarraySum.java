package leetcode.top100.ame.substring;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/30 18:25
 * @Version 1.0
 */
public class SubarraySum {

	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0;
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int target = sum - k;
			if (map.containsKey(target)) {
				ans += map.get(target);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return ans;
	}

}
