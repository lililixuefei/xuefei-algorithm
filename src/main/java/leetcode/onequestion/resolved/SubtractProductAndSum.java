package leetcode.onequestion.resolved;

/**
 * @description: 整数的各位积和之差
 * @author: xuefei
 * @date: 2023/08/09 21:34
 */
public class SubtractProductAndSum {

    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        while (n > 0) {
            int i = n % 10;
            sum += i;
            product *= i;
            n = n / 10;
        }
        return product - sum;
    }

}
