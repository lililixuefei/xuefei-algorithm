package leetcode.swordfingeroffer.unresolved;

/**
 * @description: 剑指 Offer 64. 求1+2+…+n
 * @author: xuefei
 * @date: 2023/07/30 17:35
 */
public class SumNums {

    int res = 0;

    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }


    public int sumNums2(int n) {
        return (1 + n) * n / 2;
    }

}
