package leetcode.basic.dfs;

/**
 * @description: 岛屿数量
 * @author: xuefei
 * @date: 2023/03/29 22:48
 */
public class NumIslands {

	public int numIslands(char[][] grid) {
		int lands = 0;
		int n = grid.length;
		int m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '1') {
					lands++;
					dfs(grid, i, j);
				}
			}
		}
		return lands;
	}

	private void dfs(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
			return;
		}
		if (grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		dfs(grid, i - 1, j);
		dfs(grid, i + 1, j);
		dfs(grid, i, j - 1);
		dfs(grid, i, j + 1);
	}

}
