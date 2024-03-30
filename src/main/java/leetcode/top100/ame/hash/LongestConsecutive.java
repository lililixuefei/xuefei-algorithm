package leetcode.top100.ame.hash;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/27 22:06
 * @Version 1.0
 */
public class LongestConsecutive {

	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}
		int maxCount = 0;
		for (int num : nums) {
			if (set.contains(num - 1)) {
				continue;
			}
			int cur = num + 1;
			int count = 1;
			while (set.contains(cur)) {
				cur++;
				count++;
			}
			maxCount = Math.max(maxCount, count);
		}
		return maxCount;
	}

}
