package leetcode.daily;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 和相等的子数组
 * @author: xuefei
 * @date: 2023/03/26 19:26
 */
public class FindSubarrays {

	public boolean findSubarrays(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i < nums.length; i++) {
			int res = nums[i] + nums[i - 1];
			if (set.contains(res)) {
				return true;
			}
			set.add(res);
		}
		return false;
	}

}
