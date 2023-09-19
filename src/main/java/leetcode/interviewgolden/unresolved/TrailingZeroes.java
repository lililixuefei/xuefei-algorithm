package leetcode.interviewgolden.unresolved;

/**
 * @Description 阶乘尾数
 * @Author xuefei
 * @Date 2023/9/19 22:51
 * @Version 1.0
 */
public class TrailingZeroes {

    public static void main(String[] args) {
        trailingZeroes(13);
    }

    public static int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }


    public static int trailingZeroes_wrong(int n) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        }
        int count = 0;
        while (ans % 10 == 0) {
            count++;
            ans = ans / 10;
        }
        return count;
    }

}
