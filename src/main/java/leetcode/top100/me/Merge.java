package leetcode.top100.me;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: xuefei
 * @date: 2024/03/27 19:59
 */
public class Merge {


    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = ans.get(ans.size() - 1);
            int[] interval = intervals[i];
            if (cur[1] >= interval[0]) {
                cur[1] = interval[1];
            } else {
                ans.add(interval);
            }
        }
        return ans.toArray(new int[0][0]);

    }

}
