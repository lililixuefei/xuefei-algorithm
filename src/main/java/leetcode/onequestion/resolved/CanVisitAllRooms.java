package leetcode.onequestion.resolved;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 钥匙和房间
 * @author: xuefei
 * @date: 2023/08/13 21:29
 */
public class CanVisitAllRooms {


    int num = 1;

    boolean[] visited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        visited = new boolean[rooms.size()];
        visited[0] = true;

        visited(rooms.get(0), rooms);

        return num == rooms.size();
    }

    private void visited(List<Integer> keys, List<List<Integer>> rooms) {
        if (keys == null || keys.size() == 0) {
            return;
        }
        for (Integer key : keys) {
            if (visited[key]) {
                continue;
            }
            num++;
            visited[key] = true;
            visited(rooms.get(key), rooms);
        }
    }


    public boolean canVisitAllRooms_bfs(List<List<Integer>> rooms) {
        int n = rooms.size(), num = 0;
        boolean[] vis = new boolean[n];
        Queue<Integer> que = new LinkedList<>();
        vis[0] = true;
        que.offer(0);
        while (!que.isEmpty()) {
            int x = que.poll();
            num++;
            for (int it : rooms.get(x)) {
                if (!vis[it]) {
                    vis[it] = true;
                    que.offer(it);
                }
            }
        }
        return num == n;
    }


}
