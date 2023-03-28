package leetcode.interviewgolden.nodone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 水域大小
 * @author: xuefei
 * @date: 2023/03/28 23:25
 */
public class PondSizes {

	public int[] pondSizes(int[][] land) {
		List<Integer> list = new ArrayList<>();
		int temp;
		// 遍历矩阵每个元素
		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[0].length; j++) {
				temp = findPool(land, i, j);
				if (temp != 0) {
					list.add(temp);
				}
			}
		}
		int[] result = list.stream().mapToInt(Integer::valueOf).toArray();
		Arrays.sort(result);
		return result;
	}

	private int findPool(int[][] land, int x, int y) {
		int num = 0;
		if (x < 0 || x >= land.length || y < 0 || y >= land[0].length || land[x][y] != 0) {
			return num;
		}
		num++;
		land[x][y] = -1;   // 如果为0，就转换为-1，避免重复搜索
		num += findPool(land, x + 1, y);
		num += findPool(land, x - 1, y);
		num += findPool(land, x, y + 1);
		num += findPool(land, x, y - 1);
		num += findPool(land, x + 1, y + 1);
		num += findPool(land, x + 1, y - 1);
		num += findPool(land, x - 1, y + 1);
		num += findPool(land, x - 1, y - 1);
		return num;
	}

}
