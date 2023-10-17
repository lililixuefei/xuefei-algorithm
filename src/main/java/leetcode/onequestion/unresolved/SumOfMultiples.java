package leetcode.onequestion.unresolved;

/**
 * @description: 倍数求和
 * @author: xuefei
 * @date: 2023/10/17 18:26
 */
public class SumOfMultiples {

    public static void main(String[] args) {
        System.out.println(sumOfMultiples(9));
        System.out.println(sumOfMultiples(10));
    }

    public static int sumOfMultiples2(int n) {
        return f(n, 3) + f(n, 5) + f(n, 7) - f(n, 3 * 5) - f(n, 3 * 7) - f(n, 5 * 7) + f(n, 3 * 5 * 7);
    }

    public static int f(int n, int m) {
        return (m + n / m * m) * (n / m) / 2;
    }

    public static int sumOfMultiples(int n) {
        int ans = 0;
        for (int i = 3; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                ans += i;
            }
        }
        return ans;
    }

}
