package dp;

/**
 * @description: 爬楼梯   https://leetcode.cn/problems/climbing-stairs/
 * @author: xuefei
 * @date: 2022/06/30 23:15
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n == 1 || n == 2){
            return n;
        }


        int[] stairs = new int[n];
        stairs[0] = 1;
        stairs[1] = 2;
        for (int i = 2; i < n; i++) {
            stairs[i] = stairs[i-1] + stairs[i-2];
        }

        return stairs[n-1];
    }

    public int climbStairs2(int n) {
        int p = 0;
        int q = 0;
        int r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }


}
