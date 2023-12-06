package labuladong.math;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/12/01 11:24
 */
public class TrailingZeroes {


    int trailingZeroes(int n) {
        int res = 0;
        long divisor = 5;
        while (divisor <= n) {
            res += n / divisor;
            divisor *= 5;
        }
        return res;
    }

}
