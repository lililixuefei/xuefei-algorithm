package leetcode.onequestion;

import java.util.Arrays;

/**
 * @description: 矩阵中的和
 * @author: xuefei
 * @date: 2023/08/12 00:21
 */
public class MatrixSum {

    public static void main(String[] args) {
        int[][] nums = {{7, 2, 1}, {6, 4, 2}, {6, 5, 3}, {3, 2, 1}};
        System.out.println(matrixSum(nums));

    }

    public static int matrixSum(int[][] nums) {

        for (int[] num : nums) {
            Arrays.sort(num);
        }

        int cols = nums[0].length;
        int rows = nums.length;

        int matrixSum = 0;
        for (int i = 0; i < cols; i++) {
            int value = Integer.MIN_VALUE;
            for (int j = 0; j < rows; j++) {
                value = Math.max(value, nums[j][i]);
            }
            matrixSum += value;
        }
        return matrixSum;

    }

}
