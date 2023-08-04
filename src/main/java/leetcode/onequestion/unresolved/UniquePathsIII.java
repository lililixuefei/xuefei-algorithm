package leetcode.onequestion.unresolved;

/**
 * @description: 不同路径 III
 * @author: xuefei
 * @date: 2023/08/04 21:42
 */
public class UniquePathsIII {

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int uniquePathsIII(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int si = 0, sj = 0, n = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0) {
                    n++;
                } else if (grid[i][j] == 1) {
                    n++;
                    si = i;
                    sj = j;
                }
            }
        }
        return dfs2(grid, si, sj, n);
    }

    public int dfs2(int[][] grid, int i, int j, int n) {
        int r = grid.length;
        int c = grid[0].length;
        if (i < 0 || i >= r || j < 0 || j >= c || grid[i][j] == -1) {
            return 0;
        }

        if (grid[i][j] == 2) {
            return n == 0 ? 1 : 0;
        }
        int t = grid[i][j];
        int res = 0;
        for (int[] dir : dirs) {
            grid[i][j] = -1;
            int ni = i + dir[0];
            int nj = j + dir[1];
            res += dfs2(grid, ni, nj, n - 1);
            grid[i][j] = t;
        }
        return res;
    }

}
