package leetcode.topic.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 两数之和
 * @author: xuefei
 * @date: 2023/07/10 22:41
 */
public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> hashtable = new HashMap<>();
		for (int i = 0; i < nums.length; ++i) {
			if (hashtable.containsKey(target - nums[i])) {
				return new int[]{hashtable.get(target - nums[i]), i};
			}
			hashtable.put(nums[i], i);
		}
		return new int[0];
	}


}
