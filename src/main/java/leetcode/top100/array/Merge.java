package leetcode.top100.array;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Description 合并区间
 * @Author xuefei
 * @Date 2023/12/24 16:28
 * @Version 1.0
 */
public class Merge {

	public int[][] merge(int[][] intervals) {
		LinkedList<int[]> res = new LinkedList<>();
		// 按区间的 start 升序排列
		Arrays.sort(intervals, (a, b) -> {
			return a[0] - b[0];
		});

		res.add(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			int[] curr = intervals[i];
			// res 中最后一个元素的引用
			int[] last = res.getLast();
			if (curr[0] <= last[1]) {
				last[1] = Math.max(last[1], curr[1]);
			} else {
				// 处理下一个待合并区间
				res.add(curr);
			}
		}
		return res.toArray(new int[0][0]);
	}

}
