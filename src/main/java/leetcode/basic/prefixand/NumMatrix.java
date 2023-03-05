package leetcode.basic.prefixand;

/**
 * @description: 二维区域和检索 - 矩阵不可变
 * @author: xuefei
 * @date: 2023/02/27 22:16
 */
public class NumMatrix {

	int[][] preAnd;

	public NumMatrix(int[][] matrix) {
		int rowL = matrix.length;
		int colL = matrix[0].length;
		preAnd = new int[rowL + 1][colL + 1];
		for (int l = 1; l <= rowL; l++) {
			for (int i = 1; i <= colL; i++) {
				preAnd[l][i] = preAnd[l][i - 1] + preAnd[l - 1][i] - preAnd[l - 1][i - 1] + matrix[l - 1][i - 1];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return preAnd[row2 + 1][col2 + 1] - preAnd[row1][col2 + 1] - preAnd[row2 + 1][col1] + preAnd[row1][col1];
	}
}

