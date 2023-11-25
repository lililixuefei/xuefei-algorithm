package leetcode.top100;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/11/25 20:59
 * @Version 1.0
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

}
