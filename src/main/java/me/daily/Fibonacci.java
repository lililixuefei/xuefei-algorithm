package me.daily;

/**
 * @description: 斐波那契
 * @author: xuefei
 * @date: 2022/10/11 23:21
 */
public class Fibonacci {

    public static void main(String[] args) {

        System.out.println(fibonacci_1(15));
        System.out.println(fibonacci_2(15));

    }

    /**
     * 0 1 1 2 3 5 8 ...
     *
     * @param n
     * @return
     */
    public static int fibonacci_1(int n) {
        if (n <= 2) {
            return n - 1;
        }
        return fibonacci_1(n - 1) + fibonacci_1(n - 2);
    }

    public static int fibonacci_2(int n) {
        if (n <= 2) {
            return n - 1;
        }
        int i = 1;
        int j = 1;
        int ans = 0;
        for (int m = 3; m < n; m++) {
            ans = i + j;
            i = j;
            j = ans;
        }
        return ans;
    }
}
