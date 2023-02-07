package xuefei.done.leetcode.study_plan.programme_ability;

/**
 * @description: 位1的个数   https://leetcode.cn/problems/number-of-1-bits/
 * @author: xuefei
 * @date: 2022/05/15 21:21
 */
public class HammingWeight {

    public static void main(String[] args) {
        System.out.println(hammingWeight(987));
    }


    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
}
