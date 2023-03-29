package leetcode.basic.dfs;

/**
 * @description: 岛屿的最大面积
 * @author: xuefei
 * @date: 2023/03/29 23:34
 */
public class MaxAreaOfIsland {

	public int maxAreaOfIsland(int[][] grid) {
		int maxArea = 0;
		int n = grid.length;
		int m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					maxArea = Math.max(maxArea, dfs(grid, i, j));
				}
			}
		}
		return maxArea;
	}

	private int dfs(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
			return 0;
		}
		if (grid[i][j] == 0) {
			return 0;
		}
		grid[i][j] = 0;
		return dfs(grid, i - 1, j) +
				dfs(grid, i + 1, j) +
				dfs(grid, i, j - 1) +
				dfs(grid, i, j + 1) + 1;
	}

}
