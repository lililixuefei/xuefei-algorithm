package leetcode.onequestion.resolved;

import java.util.Arrays;

/**
 * @description: 删除每行中的最大值
 * @author: xuefei
 * @date: 2023/07/27 22:03
 */
public class DeleteGreatestValue {

	public int deleteGreatestValue(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		for (int i = 0; i < n; i++) {
			Arrays.sort(grid[i]);
		}
		int ans = 0;
		for (int i = m - 1; i >= 0; i--) {
			int value = Integer.MIN_VALUE;
			for (int j = 0; j < n; j++) {
				value = Math.max(grid[j][i], value);
			}
			ans += value;
		}
		return ans;
	}

}
