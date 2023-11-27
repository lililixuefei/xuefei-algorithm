package leetcode.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description N 皇后
 * @Author xuefei
 * @Date 2023/11/27 22:43
 * @Version 1.0
 */
public class SolveNQueens {


    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        Character[][] matrix = new Character[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], '.');
        }
        // 矩阵
        dfs(matrix, 0);
        return res;
    }

    private void dfs(Character[][] matrix, int row) {
        //base case ：当行数超过n
        if (row == matrix.length) {
            List<String> rowList = new LinkedList<>();
            //处理board
            for (int i = 0; i < matrix.length; i++) {
                StringBuilder str = new StringBuilder();//一行初始化一次
                for (int j = 0; j < matrix.length; j++) {
                    str.append(matrix[i][j]);
                }
                rowList.add(str.toString());
            }
            //将一种解法装入
            res.add(new LinkedList<>(rowList));
            return;
        }

        for (int col = 0; col < matrix.length; col++) {
            if (!isValid(matrix, row, col)) {
                continue;
            }
            matrix[row][col] = 'Q';
            dfs(matrix, row + 1);
            matrix[row][col] = '.';
        }
    }


    private boolean isValid(Character[][] matrix, int row, int col) {
        //检查上方
        for (int row1 = row; row1 >= 0; row1--) {
            if ('Q' == matrix[row1][col]) {
                return false;
            }
        }
        //检查左上方
        for (int row1 = row - 1, col1 = col - 1; row1 >= 0 && col1 >= 0; row1--, col1--) {
            if ('Q' == matrix[row1][col1]) {
                return false;
            }
        }
        //检查右上
        for (int row1 = row - 1, col1 = col + 1; row1 >= 0 && col1 < matrix.length; row1--, col1++) {
            if ('Q' == matrix[row1][col1]) {
                return false;
            }
        }
        return true;
    }

}
