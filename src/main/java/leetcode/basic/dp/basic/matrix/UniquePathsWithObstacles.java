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

	public int uniquePathsWithObstacles_dp(int[][] obstacleGrid) {
		int n = obstacleGrid.length;
		int m = obstacleGrid[0].length;
		int[][] dp = new int[n][m];
		//(0,0)这个格子可能有障碍物
		dp[0][0] = (obstacleGrid[0][0] == 1) ? 0 : 1;
		//处理第一列
		for (int i = 1; i < n; ++i) {
			if (obstacleGrid[i][0] == 1 || dp[i - 1][0] == 0) {
				dp[i][0] = 0;
			} else {
				dp[i][0] = 1;
			}
		}
		//处理第一行
		for (int j = 1; j < m; ++j) {
			if (obstacleGrid[0][j] == 1 || dp[0][j - 1] == 0) {
				dp[0][j] = 0;
			} else {
				dp[0][j] = 1;
			}
		}
		for (int i = 1; i < n; ++i) {
			for (int j = 1; j < m; ++j) {
				//如果当前格子是障碍物
				if (obstacleGrid[i][j] == 1) {
					dp[i][j] = 0;
					//路径总数来自于上方(dp[i-1][j])和左方(dp[i][j-1])
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[n - 1][m - 1];
	}


	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		return dfs(new HashMap<>(), obstacleGrid, 0, 0);
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
