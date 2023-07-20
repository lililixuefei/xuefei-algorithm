package leetcode.swordfingeroffer;

/**
 * @description: 剑指 Offer 29. 顺时针打印矩阵
 * @author: xuefei
 * @date: 2023/07/19 16:26
 */
public class SpiralOrder {

	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		spiralOrder(matrix);
	}

	// wrong
	public static int[] spiralOrder(int[][] matrix) {
		int[] ans = new int[matrix.length * matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int index = (i * matrix[0].length) + j;
				System.out.println(index + "--" + i + "-" + j);
				ans[index] = matrix[i][j];
			}
		}
		return ans;
	}

}
