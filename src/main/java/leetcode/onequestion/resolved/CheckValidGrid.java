package leetcode.onequestion.resolved;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/09/13 19:13
 */
public class CheckValidGrid {

    public boolean checkValidGrid(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return false;
        }
        return dfs(grid, 0, 0, 0);
    }


    public boolean dfs(int[][] grid, int i, int j, int step) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return step > (rows * columns - 1);
        }
        if (step != grid[i][j]) {
            return false;
        }
        return dfs(grid, i + 2, j + 1, step + 1)
                || dfs(grid, i + 2, j - 1, step + 1)
                || dfs(grid, i + 1, j + 2, step + 1)
                || dfs(grid, i + 1, j - 2, step + 1)
                || dfs(grid, i - 2, j + 1, step + 1)
                || dfs(grid, i - 2, j - 1, step + 1)
                || dfs(grid, i - 1, j + 2, step + 1)
                || dfs(grid, i - 1, j - 2, step + 1);
    }

}
