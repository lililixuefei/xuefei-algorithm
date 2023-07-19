package leetcode.onequestion.unresolved;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 模拟行走机器人
 * @author: xuefei
 * @date: 2023/07/19 11:42
 */
public class RobotSim {

	public int robotSim(int[] commands, int[][] obstacles) {

		int result = 0;
		int x = 0;
		int y = 0;
		int direction = 0;

		int[] directX = new int[]{0, 1, 0, -1};
		int[] directY = new int[]{1, 0, -1, 0};

		// 用 set 存储障碍物的坐标
		Set<String> obstaclesSet = new HashSet<>();
		for (int i = 0; i < obstacles.length; i++) {
			obstaclesSet.add(obstacles[i][0] + "," + obstacles[i][1]);
		}

		for (int com : commands) {
			if (com == -2) {
				// turn left
				direction = (direction + 3) % 4;
			} else if (com == -1) {
				// turn right
				direction = (direction + 1) % 4;
			} else {
				for (int i = 1; i <= com; i++) {
					// 下一步的坐标
					int newX = x + directX[direction];
					int newY = y + directY[direction];
					// 遇到障碍物，停止前进
					if (obstaclesSet.contains(newX + "," + newY)) {
						break;
					}
					// 前进
					x = newX;
					y = newY;
					// 最大欧式距离的平方
					result = Math.max(result, x * x + y * y);
				}
			}
		}
		return result;
	}

}
