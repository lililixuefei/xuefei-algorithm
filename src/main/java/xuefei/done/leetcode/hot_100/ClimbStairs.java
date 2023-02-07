package xuefei.done.leetcode.hot_100;

/**
 * @description: 爬楼梯   https://leetcode.cn/problems/climbing-stairs/
 * @author: xuefei
 * @date: 2022/06/26 20:29
 */
public class ClimbStairs {

    public static void main(String[] args) {

    }

    public int climbStairs(int n) {

        int[] result = new int[n];
        climbStairsRecursion(n, result);

        return result[n - 1];
    }

    public int climbStairsDP(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 2;
        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n - 1];
    }

    private int climbStairsRecursion(int n, int[] result) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        if (result[n - 1] == 0) {
            result[n - 1] = climbStairsRecursion(n - 1, result);
        }

        if (result[n - 2] == 0) {
            result[n - 2] = climbStairsRecursion(n - 2, result);
        }
        return result[n - 1] + result[n - 2];
    }
}
