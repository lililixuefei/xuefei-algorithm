package leetcode.top100.matrix;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/24 20:17
 * @Version 1.0
 */
public class Rotate {

	public void rotate(int[][] matrix) {
		int n = matrix.length;
		// 先沿对角线反转二维矩阵
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				// swap(matrix[i][j], matrix[j][i]);
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		// 然后反转二维矩阵的每一行
		for (int[] row : matrix) {
			reverse(row);
		}
	}

	// 反转一维数组
	void reverse(int[] arr) {
		int i = 0, j = arr.length - 1;
		while (j > i) {
			// swap(arr[i], arr[j]);
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}

}

