package leetcode.onequestion.unresolved;

import java.util.*;

/**
 * @description: 收集树中金币
 * @author: xuefei
 * @date: 2023/09/21 18:17
 */
public class CollectTheCoins {

    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, e -> new ArrayList<>());
        int[] deg = new int[n];
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            graph[x].add(y);
            graph[y].add(x); // 建图
            deg[x]++;
            deg[y]++; // 统计每个节点的度数（邻居个数）
        }

        int leftEdges = n - 1; // 剩余边数
        // 拓扑排序，去掉没有金币的子树
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 1 && coins[i] == 0) { // 没有金币的叶子
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            leftEdges--; // 删除节点到其父节点的边
            for (int y : graph[q.poll()]) {
                if (--deg[y] == 1 && coins[y] == 0) { // 没有金币的叶子
                    q.add(y);
                }
            }
        }

        // 再次拓扑排序
        for (int i = 0; i < n; i++) {
            if (deg[i] == 1 && coins[i] == 1) { // 有金币的叶子（判断 coins[i] 是避免把没有金币的叶子也算进来）
                q.add(i);
            }
        }
        leftEdges -= q.size(); // 删除所有叶子（到其父节点的边）
        for (int x : q) { // 遍历所有叶子
            for (int y : graph[x]) {
                if (--deg[y] == 1) { // y 现在是叶子了
                    leftEdges--; // 删除 y（到其父节点的边）
                }
            }
        }
        return Math.max(leftEdges * 2, 0);
    }

}
