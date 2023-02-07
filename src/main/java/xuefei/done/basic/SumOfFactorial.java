package xuefei.done.basic;

/**
 * @description:
 * @author: xuefei
 * @date: 2022/04/10 00:36
 */
public class SumOfFactorial {


    /**
     * 给定一个参数N,
     * 返回:
     * 1!+2!+3!+4!+...+N!的结果
     */

    public static void main(String[] args) {
        System.out.println(f1(10));
        System.out.println(f2(10));
    }

    public static long f1(long n) {
        long ans = 0;
        for (long i = 1; i <= n; i++) {
            ans += factorial(i);
        }
        return ans;
    }

    private static long factorial(long n) {
        long ans = 1;
        for (long i = 1; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }

    public static long f2(long n) {
        long ans = 0;
        long cur = 1;
        for (long i = 1; i <= n; i++) {
            cur = cur * i;
            ans += cur;
        }
        return ans;
    }

}
