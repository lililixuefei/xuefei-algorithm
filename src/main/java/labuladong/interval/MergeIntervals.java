package labuladong.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description 合并区间
 * @Author xuefei
 * @Date 2023/7/11 10:16 AM
 * @Version 1.0
 */
public class MergeIntervals {

	public static void main(String[] args) {
		int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
		mergeIntervals(nums);
	}


	public static int[][] mergeIntervals(int[][] intervals) {
		if (intervals.length == 0) {
			return new int[0][2];
		}

		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		ArrayList<int[]> result = new ArrayList<>();

		for (int i = 0; i < intervals.length; i++) {
			int left = intervals[i][0];
			int right = intervals[i][1];

			if (result.size() == 0 || result.get(result.size() - 1)[1] < left) {
				result.add(intervals[i]);
			} else {
				result.get(result.size() - 1)[1] = Math.max(right, result.get(result.size() - 1)[1]);
			}
		}

		return result.toArray(new int[result.size()][]);
	}

}
