package study.zuoshen.novice_class;

import java.util.stream.LongStream;

/**
 * @description: 阶乘计算
 * @author: xuefei
 * @date: 2022/11/13 22:35
 */
public class FactorialCalculation {


    public long factorialCalc(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }


    public long factorialUsingStreams(int n) {
        return LongStream.rangeClosed(1, n).reduce(1, (long x, long y) -> x * y);
    }
}
