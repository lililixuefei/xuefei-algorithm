package leetcode.onequestion.unresolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 统计无向图中无法互相到达点对数
 * @Author xuefei
 * @Date 2023/10/21 21:58
 * @Version 1.0
 */
public class CountPairs2 {

    public long countPairs(int n, int[][] edges) {
        // 建图
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, e -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            graph[x].add(y);
            graph[y].add(x);
        }

        boolean[] vis = new boolean[n];
        long ans = 0;
        for (int i = 0, total = 0; i < n; i++) {
            // 未访问的点：说明找到了一个新的连通块
            if (!vis[i]) {
                int size = dfs(i, graph, vis);
                ans += (long) size * total;
                total += size;
            }
        }
        return ans;
    }

    private int dfs(int x, List<Integer>[] graph, boolean[] vis) {
        // 避免重复访问同一个点
        vis[x] = true;
        int size = 1;
        for (int y : graph[x]) {
            if (!vis[y]) {
                size += dfs(y, graph, vis);
            }
        }
        return size;
    }
}
