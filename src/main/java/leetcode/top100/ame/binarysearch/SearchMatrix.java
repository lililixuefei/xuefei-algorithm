package leetcode.top100.ame.binarysearch;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/17 22:44
 * @Version 1.0
 */
public class SearchMatrix {


    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;

    }

}
