package leetcode.swordfingeroffer.unresolved;

///**
// * @description: 剑指 Offer 14- I. 剪绳子
// * @author: xuefei
// * @date: 2023/08/02 23:21
// */
public class CuttingRope {


    public int cuttingRope2(int n) {
        if (n <= 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int count = n / 3;
        int m = n % 3;
        if (m == 0) {
            return power(3, count);
        } else if (m == 1) {
            return power(3, count - 1) * 4;
        } else {
            return power(3, count) * 2;
        }

    }

    private int power(int n, int count) {
        int result = 1;
        for (int i = 0; i < count; i++) {
            result *= n;
        }
        return result;
    }

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }

    public int cuttingRope_wrong(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(j * (i - j), dp[i - j] * j);
            }
        }
        return dp[n];
    }

}
