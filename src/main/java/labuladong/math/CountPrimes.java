package labuladong.math;

import java.util.Arrays;

/**
 * @description: 如何用算法高效寻找素数
 * @author: xuefei
 * @date: 2023/12/01 11:10
 */
public class CountPrimes {


    int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrim[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                count++;
            }
        }

        return count;
    }


//    int countPrimes(int n) {
//        boolean[] isPrim = new boolean[n];
//        // 将数组都初始化为 true
//        Arrays.fill(isPrim, true);
//
//        for (int i = 2; i < n; i++)
//            if (isPrim[i])
//                // i 的倍数不可能是素数了
//                for (int j = 2 * i; j < n; j += i)
//                    isPrim[j] = false;
//
//        int count = 0;
//        for (int i = 2; i < n; i++)
//            if (isPrim[i]) count++;
//
//        return count;
//    }


//    int countPrimes(int n) {
//        int count = 0;
//        for (int i = 2; i < n; i++)
//            if (isPrim(i)) count++;
//        return count;
//    }
//
//    // 判断整数 n 是否是素数
//    boolean isPrime(int n) {
//        for (int i = 2; i < n; i++)
//            if (n % i == 0)
//                // 有其他整除因子
//                return false;
//        return true;
//    }
//    boolean isPrime(int n) {
//        for (int i = 2; i * i <= n; i++)
//            ...
//    }

}
