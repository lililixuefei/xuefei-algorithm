package leetcode.swordfingeroffer.unresolved;

/**
 * @description: 剑指 Offer 13. 机器人的运动范围
 * @author: xuefei
 * @date: 2023/07/30 16:27
 */
public class MovingCount {

    public static void main(String[] args) {
        MovingCount movingCount = new MovingCount();
        movingCount.movingCount(3, 2, 1);
    }


    public int movingCount2(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        dfs(m, n, k, 0, 0, visited);
        return res;
    }

    // 记录合法坐标数
    int res = 0;

    public void dfs(int m, int n, int k, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return;
        }

        if (i / 10 + i % 10 + j / 10 + j % 10 > k) {
            // 坐标和超出 k 的限制
            return;
        }

        if (visited[i][j]) {
            // 之前已经访问过当前坐标
            return;
        }

        // 走到一个合法坐标
        res++;
        visited[i][j] = true;

        // DFS 遍历上下左右
        dfs(m, n, k, i + 1, j, visited);
        dfs(m, n, k, i, j + 1, visited);
        dfs(m, n, k, i - 1, j, visited);
        dfs(m, n, k, i, j - 1, visited);
    }


    public int movingCount(int m, int n, int k) {

        boolean[][] visited = new boolean[m][n];

        return process(0, 0, m, n, k, visited);

    }

    public int process(int i, int j, int m, int n, int k, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        if (!isLessK(i, j, k) || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        res++;
        process(i + 1, j, m, n, k, visited);
        process(i, j + 1, m, n, k, visited);
        process(i - 1, j, m, n, k, visited);
        process(i, j - 1, m, n, k, visited);
        return res;
    }

    private boolean isLessK(int i, int j, int k) {
        char[] chars1 = String.valueOf(i).toCharArray();
        char[] chars2 = String.valueOf(j).toCharArray();
        int sum = 0;
        for (char c : chars1) {
            sum += (c - '0');
        }
        for (char c : chars2) {
            sum += (c - '0');
        }
        return sum <= k;
    }

}
