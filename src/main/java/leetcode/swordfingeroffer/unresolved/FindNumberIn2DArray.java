package leetcode.swordfingeroffer.unresolved;

/**
 * @description: 剑指 Offer 04. 二维数组中的查找
 * @author: xuefei
 * @date: 2023/07/18 23:21
 */
public class FindNumberIn2DArray {

	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		boolean found = false;
		if (matrix == null || matrix.length < 1) {
			return found;
		}
		int row = 0;
		int column = matrix[0].length - 1;
		while (row < matrix.length && column >= 0) {
			if (matrix[row][column] == target) {
				found = true;
				break;
			} else if (matrix[row][column] > target) {
				column--;
			} else {
				row++;
			}
		}
		return found;
	}

}
