package leetcode.swordfinger_offer;

/**
 * @description: 剑指 Offer 04. 二维数组中的查找
 * @author: xuefei
 * @date: 2022/11/12 23:03
 */
public class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1) {
            return false;
        }
        boolean found = false;
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
