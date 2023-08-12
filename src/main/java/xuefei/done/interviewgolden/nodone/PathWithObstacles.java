package xuefei.done.interviewgolden.nodone;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 迷路的机器人
 * @author: xuefei
 * @date: 2023/03/11 17:08
 */
public class PathWithObstacles {


	// 行数
	int r = 0;
	// 列数
	int c = 0;
	// 记录路径
	List<List<Integer>> path = new LinkedList<>();

	public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
		r = obstacleGrid.length;
		// 空网格
		if (r == 0) {
			return path;
		}
		c = obstacleGrid[0].length;
		// 终点有障碍
		if (obstacleGrid[r - 1][c - 1] == 1) {
			return path;
		}

		// 记录数组
		boolean[][] visit = new boolean[r][c];
		backtrack(obstacleGrid, 0, 0, visit);
		return path;
	}

	public boolean backtrack(int[][] obstacleGrid, int x, int y, boolean[][] visit) {
		// 越界，有障碍，已访问
		if (x >= r || y >= c || obstacleGrid[x][y] == 1 || visit[x][y]) {
			return false;
		}
		// 如果不是以上情况，说明这个格子值得探索，做出选择
		path.add(Arrays.asList(x, y));
		visit[x][y] = true;
		// 选择后是否到达终点
		if (x == r - 1 && y == c - 1) {
			return true;
		}
		// 选择后没到终点，先尝试向下，再尝试向右，神奇的或运算
		if (backtrack(obstacleGrid, x + 1, y, visit) || backtrack(obstacleGrid, x, y + 1, visit)) {
			return true;
		}
		// 既不能向下也不能向右，是个死胡同，撤销选择
		path.remove(path.size() - 1);
		return false;
	}

}
