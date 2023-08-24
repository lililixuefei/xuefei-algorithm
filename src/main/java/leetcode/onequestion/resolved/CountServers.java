package leetcode.onequestion.resolved;

/**
 * @Description 统计参与通信的服务器
 * @Author xuefei
 * @Date 2023/8/24 22:24
 * @Version 1.0
 */
public class CountServers {

    public int countServers(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[] rows = new int[n];
        int[] columns = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    columns[j]++;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && (rows[i] > 1 || columns[j] > 1)) {
                    ans++;
                }
            }
        }

        return ans;
    }

}
