package leetcode.basic.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 最小区间
 * @author: xuefei
 * @date: 2023/03/23 23:26
 */
public class SmallestRange {

	public int[] smallestRange(List<List<Integer>> nums) {
		int size = nums.size();
		Map<Integer, List<Integer>> indices = new HashMap<>();
		int xMin = Integer.MAX_VALUE;
		int xMax = Integer.MIN_VALUE;
		for (int i = 0; i < size; i++) {
			for (int x : nums.get(i)) {
				List<Integer> list = indices.getOrDefault(x, new ArrayList<>());
				list.add(i);
				indices.put(x, list);
				xMin = Math.min(xMin, x);
				xMax = Math.max(xMax, x);
			}
		}

		int[] freq = new int[size];
		int inside = 0;
		int left = xMin;
		int right = xMin - 1;
		int bestLeft = xMin;
		int bestRight = xMax;

		while (right < xMax) {
			right++;
			if (indices.containsKey(right)) {
				for (int x : indices.get(right)) {
					freq[x]++;
					if (freq[x] == 1) {
						inside++;
					}
				}
				while (inside == size) {
					if (right - left < bestRight - bestLeft) {
						bestLeft = left;
						bestRight = right;
					}
					if (indices.containsKey(left)) {
						for (int x : indices.get(left)) {
							freq[x]--;
							if (freq[x] == 0) {
								inside--;
							}
						}
					}
					left++;
				}
			}
		}

		return new int[]{bestLeft, bestRight};
	}

}
