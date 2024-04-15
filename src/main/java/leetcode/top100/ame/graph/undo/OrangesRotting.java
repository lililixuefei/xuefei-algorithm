package leetcode.top100.ame.graph.undo;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/15 23:01
 * @Version 1.0
 */
public class OrangesRotting {

	public int orangesRotting(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int count = 0;
		Deque<int[]> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					count++;
				}
				if (grid[i][j] == 2) {
					queue.add(new int[]{i, j});
				}
			}
		}
		int round = 0;
		while (!queue.isEmpty() && count != 0) {
			round++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] orange = queue.poll();
				int r = orange[0];
				int c = orange[1];
				if (r - 1 >= 0 && grid[r - 1][c] == 1) {
					grid[r - 1][c] = 2;
					count--;
					queue.add(new int[]{r - 1, c});
				}
				if (r + 1 < m && grid[r + 1][c] == 1) {
					grid[r + 1][c] = 2;
					count--;
					queue.add(new int[]{r + 1, c});
				}
				if (c - 1 >= 0 && grid[r][c - 1] == 1) {
					grid[r][c - 1] = 2;
					count--;
					queue.add(new int[]{r, c - 1});
				}
				if (c + 1 < n && grid[r][c + 1] == 1) {
					grid[r][c + 1] = 2;
					count--;
					queue.add(new int[]{r, c + 1});
				}
			}
		}
		if (count == 0) {
			return round;
		} else {
			return -1;
		}
	}

}
