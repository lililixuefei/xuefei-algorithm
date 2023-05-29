package leetcode.basic.dp.basic.matrix;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;

/**
 * @description: 三角形最小路径和
 * @author: xuefei
 * @date: 2023/05/30 00:14
 */
public class MinimumTotal {

	public int minimumTotal(List<List<Integer>> triangle) {

		return process(triangle, 0, 0, new HashMap<Pair, Integer>());
	}

	public int process(List<List<Integer>> triangle, int i, int j, HashMap<Pair, Integer> dp) {
		int size1 = triangle.size();
		if (i >= size1) {
			return 0;
		}
		int size2 = triangle.get(i).size();
		// 边界
		if (j >= size2) {
			return 0;
		}
		if (i == size1 - 1 && j == size2 - 1) {
			return triangle.get(i).get(j);
		}

		Pair p = new Pair(i, j);
		if (dp.containsKey(p)) {
			return dp.get(p);
		}

		int ans1 = process(triangle, i + 1, j, dp) + triangle.get(i).get(j);

		int ans2 = process(triangle, i + 1, j + 1, dp) + triangle.get(i).get(j);

		int ans = Math.min(ans1, ans2);

		dp.put(p, ans);
		return ans;

	}


}
