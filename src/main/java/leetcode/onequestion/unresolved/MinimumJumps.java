package leetcode.onequestion.unresolved;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description: 到家的最少跳跃次数
 * @author: xuefei
 * @date: 2023/08/30 23:37
 */
public class MinimumJumps {

    class Solution {

        int preA;

        int aftB;

        int target;

        Set<Integer> forbiddenSet;

        Set<Integer> visited;

        Map<Integer, Integer> dp;

        public int minimumJumps(int[] forbidden, int a, int b, int x) {
            forbiddenSet = new HashSet<>(forbidden.length);
            dp = new HashMap<>();
            visited = new HashSet<>();
            for (int i : forbidden) {
                forbiddenSet.add(i);
            }
            preA = a;
            aftB = b;
            target = x;
            int ans = dfs(0, 0);
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }


        public int dfs(int i, int pre) {
            if (i == target) {
                return 0;
            }
            int ans = Integer.MAX_VALUE;
            if (pre == 0) {
                // 往前跳、或者往后跳
                if (!visited.contains(i + preA) && i + preA <= 6000 && !forbiddenSet.contains(i + preA)) {
                    visited.add(i + preA);
                    int ans1 = dfs(i + preA, 0);
                    if (ans1 != Integer.MAX_VALUE) {
                        ans1 = ans1 + 1;
                    }
                    ans = ans1;
                }
                if (!visited.contains(i - aftB) && i - aftB >= 0 && !forbiddenSet.contains(i - aftB)) {

                    int ans2 = dfs(i - aftB, 1);
                    if (ans2 != Integer.MAX_VALUE) {
                        ans2 = ans2 + 1;
                    }
                    ans = Math.min(ans2, ans);
                }
            } else {
                // 往前跳
                if (!visited.contains(i + preA) && i + preA <= 6000 && !forbiddenSet.contains(i + preA)) {
                    visited.add(i + preA);
                    int ans3 = dfs(i + preA, 0);
                    if (ans3 != Integer.MAX_VALUE) {
                        ans3 = ans3 + 1;
                    }
                    ans = ans3;
                }
            }
            return ans;
        }
    }

}
