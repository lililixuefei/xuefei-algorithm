package leetcode.study_plan.programme_ability;


import java.util.ArrayList;
import java.util.List;

/**
 * @description: 整数的各位积和之差   https://leetcode.cn/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 * @author: xuefei
 * @date: 2022/05/15 21:32
 */
public class SubtractProductAndSum {


    public static void main(String[] args) {

    }

    public static int subtractProductAndSum(int n) {
        if (n < 10){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        while (n >= 10) {
            int i = n % 10;
            n = n / 10;
            list.add(i);
        }
        list.add(n);
        int sum = 0;
        int product = 1;
        for (Integer item : list) {
            product = product * item;
            sum = sum + item;
        }
        return product - sum;
    }
}
