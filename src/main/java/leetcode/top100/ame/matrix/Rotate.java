package leetcode.top100.ame.matrix;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/18 22:29
 * @Version 1.0
 */
public class Rotate {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int[] array : matrix) {
            reverse(array);
        }
    }

    private void reverse(int[] array) {
        int l = 0;
        int r = array.length - 1;
        while (l < r) {
            int temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            l++;
            r--;
        }
    }

}
