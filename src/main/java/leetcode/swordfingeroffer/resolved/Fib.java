package leetcode.swordfingeroffer.resolved;

/**
 * @description: 剑指 Offer 10- I. 斐波那契数列
 * @author: xuefei
 * @date: 2023/07/30 17:46
 */
public class Fib {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int m = 0;
        int k = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = (m + k) % 1000000007;
            k = fib;
            m = k;
        }
        return fib;
    }

}
