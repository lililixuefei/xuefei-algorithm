package leetcode.basic.dp.basic.matrix;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 不同路径 II
 * @author: xuefei
 * @date: 2023/05/29 23:40
 */
public class UniquePathsWithObstacles {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		return dfs(new HashMap<Pair, Integer>(), obstacleGrid, 0, 0);
	}

	private int dfs(Map<Pair, Integer> cache, int[][] arr, int i, int j) {
		Pair p = new Pair(i, j);
		if (cache.containsKey(p)) {
			return cache.get(p);
		}
		//边界/障碍物检查
		if (i >= arr.length || j >= arr[0].length || arr[i][j] == 1) {
			return 0;
		}
		//达到终点了
		if (i == arr.length - 1 && j == arr[0].length - 1) {
			return 1;
		}
		//继续往右(i,j+1)、往下(i+1,j)递归调用
		int res = dfs(cache, arr, i + 1, j) + dfs(cache, arr, i, j + 1);
		cache.put(p, res);
		return res;
	}

}
