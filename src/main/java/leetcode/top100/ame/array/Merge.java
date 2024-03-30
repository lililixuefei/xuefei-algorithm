package leetcode.top100.ame.array;

import java.util.*;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/30 19:40
 * @Version 1.0
 */
public class Merge {

	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
		LinkedList<int[]> ans = new LinkedList<>();
		ans.add(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			int[] last = ans.getLast();
			if (last[1] >= intervals[i][0]) {
				last[1] = Math.max(intervals[i][1], last[1]);
			} else {
				ans.add(intervals[i]);
			}
		}
		return ans.toArray(new int[0][0]);
	}

}
