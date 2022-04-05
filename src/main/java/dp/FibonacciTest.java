package dp;

/**
 * @description: 斐波那契数列
 * @author: xuefei
 * @date: 2022/04/05 23:10
 */
public class FibonacciTest {

    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
