package leetcode.top100.ame.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/30 20:18
 * @Version 1.0
 */
public class FirstMissingPositive {

	public int firstMissingPositive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}
		int i = 1;
		for (; i <= nums.length; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}
		return i;
	}

}
