package leetcode.interviewgolden.resolved;

/**
 * @Description 排序矩阵查找
 * @Author xuefei
 * @Date 2023/9/15 23:56
 * @Version 1.0
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length - 1;
        int m = 0;
        while (n >= 0 && m < matrix[0].length) {
            int curValue = matrix[n][m];
            if (curValue > target) {
                n--;
            } else if (curValue < target) {
                m++;
            } else {
                return true;
            }
        }
        return false;
    }

}
