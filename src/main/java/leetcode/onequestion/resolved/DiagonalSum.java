package leetcode.onequestion.resolved;

/**
 * @description: 矩阵对角线元素的和
 * @author: xuefei
 * @date: 2023/08/11 00:14
 */
public class DiagonalSum {

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(diagonalSum(mat));
    }

    public static int diagonalSum(int[][] mat) {
        int i = 0;
        int m = 0;
        int n = mat.length - 1;
        int sum = 0;
        for (int k = 0; k < mat.length; k++) {
            sum += mat[i][i++];
            sum += mat[m++][n--];
        }
        if (mat.length % 2 == 1) {
            sum -= mat[mat.length / 2][mat.length / 2];
        }
        return sum;
    }

}
