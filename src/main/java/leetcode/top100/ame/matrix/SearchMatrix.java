package leetcode.top100.ame.matrix;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/30 20:44
 * @Version 1.0
 */
public class SearchMatrix {


	public boolean searchMatrix(int[][] matrix, int target) {
		int rows = matrix.length - 1;
		int col = 0;
		while (rows >= 0 && col < matrix[0].length) {
			int value = matrix[rows][col];
			if (value > target) {
				rows--;
			} else if (value < target) {
				col++;
			} else {
				return true;
			}
		}
		return false;
	}

}
