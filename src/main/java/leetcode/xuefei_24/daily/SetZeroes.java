package leetcode.xuefei_24.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/2/18 22:14
 * @Version 1.0
 */
public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<int[]> zeroesPosition = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    int[] position = new int[]{i, j};
                    zeroesPosition.add(position);
                }
            }
        }
        for (int[] position : zeroesPosition) {
            int r = position[0];
            int c = position[1];
            for (int i = 0; i < col; i++) {
                matrix[r][i] = 0;
            }
            for (int j = 0; j < row; j++) {
                matrix[j][c] = 0;
            }
        }
    }


}
