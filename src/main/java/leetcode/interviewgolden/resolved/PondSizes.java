package leetcode.interviewgolden.resolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 水域大小
 * @Author xuefei
 * @Date 2023/9/18 23:31
 * @Version 1.0
 */
public class PondSizes {


    public int[] pondSizes(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int curValue = dfs(land, i, j);
                if (curValue != 0) {
                    ans.add(curValue);
                }
            }
        }
        int[] ansArray = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ansArray[i] = ans.get(i);
        }
        Arrays.sort(ansArray);
        return ansArray;
    }


    public int dfs(int[][] land, int i, int j) {
        if (i < 0 || i >= land.length || j < 0 || j >= land[0].length || land[i][j] != 0) {
            return 0;
        }
        land[i][j] = -1;
        return 1 + dfs(land, i + 1, j) +
                dfs(land, i, j + 1) +
                dfs(land, i - 1, j) +
                dfs(land, i, j - 1) +
                dfs(land, i + 1, j + 1) +
                dfs(land, i + 1, j - 1) +
                dfs(land, i - 1, j + 1) +
                dfs(land, i - 1, j - 1);
    }

}
