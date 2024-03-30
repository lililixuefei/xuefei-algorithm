package leetcode.top100.ame.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/30 20:25
 * @Version 1.0
 */
public class SetZeroes {


	public void setZeroes(int[][] matrix) {
		List<int[]> pos = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					int[] ans = new int[2];
					ans[0] = i;
					ans[1] = j;
					pos.add(ans);
				}
			}
		}
		for (int[] po : pos) {
			setZeroes(matrix, po[0], po[1]);
		}
	}

	private void setZeroes(int[][] matrix, int i, int j) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		for (int m = 0; m < cols; m++) {
			matrix[i][m] = 0;
		}
		for (int m = 0; m < rows; m++) {
			matrix[m][j] = 0;
		}
	}

}
