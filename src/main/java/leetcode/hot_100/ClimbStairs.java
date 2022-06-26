package leetcode.hot_100;

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
        climbStairs1(n, result);

        return result[n - 1];
    }

    private int climbStairs1(int n, int[] result) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        if (result[n - 1] == 0) {
            result[n - 1] = climbStairs1(n - 1, result);
        }

        if (result[n - 2] == 0) {
            result[n - 2] = climbStairs1(n - 2, result);
        }
        return result[n - 1] + result[n - 2];
    }
}
