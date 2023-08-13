package leetcode.onequestion.resolved;

import java.util.List;

/**
 * @description: 钥匙和房间
 * @author: xuefei
 * @date: 2023/08/13 21:29
 */
public class CanVisitAllRooms {

    boolean[] dp;

    boolean[] visited;


    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        dp = new boolean[rooms.size()];
        dp[0] = true;

        visited = new boolean[rooms.size()];
        visited[0] = true;

        visited(rooms.get(0), rooms);

        for (boolean b : dp) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private void visited(List<Integer> keys, List<List<Integer>> rooms) {
        if (keys == null || keys.size() == 0) {
            return;
        }
        for (Integer key : keys) {
            if (visited[key]) {
                continue;
            }
            dp[key] = true;
            visited[key] = true;
            visited(rooms.get(key), rooms);
        }

    }

}
