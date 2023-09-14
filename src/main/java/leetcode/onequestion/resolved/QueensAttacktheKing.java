package leetcode.onequestion.resolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 可以攻击国王的皇后
 * @author: xuefei
 * @date: 2023/09/14 18:40
 */
public class QueensAttacktheKing {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        // 构建棋盘
        int[][] matrix = new int[8][8];
        for (int[] rows : matrix) {
            Arrays.fill(rows, 0);
        }
        for (int[] queen : queens) {
            matrix[queen[0]][queen[1]] = 1;
        }

        int kingI = king[0];
        int kingJ = king[1];

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = kingI - 1; i >= 0; i--) {
            if (getQueen(matrix, kingJ, ans, i)) {
                break;
            }
        }
        for (int i = kingI + 1; i < matrix.length; i++) {
            if (getQueen(matrix, kingJ, ans, i)) {
                break;
            }
        }
        for (int j = kingJ + 1; j < matrix[0].length; j++) {
            if (getQueen(matrix, j, ans, kingI)) {
                break;
            }
        }
        for (int j = kingJ - 1; j >= 0; j--) {
            if (getQueen(matrix, j, ans, kingI)) {
                break;
            }
        }

        for (int i = kingI + 1, j = kingJ + 1; i < matrix.length && j < matrix[0].length; i++, j++) {
            if (getQueen(matrix, j, ans, i)) {
                break;
            }
        }

        for (int i = kingI - 1, j = kingJ + 1; i >= 0 && j < matrix[0].length; i--, j++) {
            if (getQueen(matrix, j, ans, i)) {
                break;
            }
        }
        for (int i = kingI - 1, j = kingJ - 1; i >= 0 && j >= 0; i--, j--) {
            if (getQueen(matrix, j, ans, i)) {
                break;
            }
        }
        for (int i = kingI + 1, j = kingJ - 1; i < matrix.length && j >= 0; i++, j--) {
            if (getQueen(matrix, j, ans, i)) {
                break;
            }
        }
        return ans;
    }

    private boolean getQueen(int[][] matrix, int j, List<List<Integer>> ans, int i) {
        if (matrix[i][j] == 1) {
            List<Integer> curAns = new ArrayList<>();
            curAns.add(i);
            curAns.add(j);
            ans.add(curAns);
            return true;
        }
        return false;
    }

}
