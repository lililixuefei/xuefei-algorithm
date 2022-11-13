package leetcode.swordfinger_offer;

/**
 * @description: 剑指 Offer 16. 数值的整数次方
 * @author: xuefei
 * @date: 2022/11/13 17:29
 */
public class MyPow {

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
