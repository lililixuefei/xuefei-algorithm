package leetcode.swordfingeroffer.unresolved;


/**
 * @description: 剑指 Offer 56 - I. 数组中数字出现的次数
 * @author: xuefei
 * @date: 2023/07/30 18:38
 */
public class SingleNumbers {

    public int[] singleNumbers(int[] nums) {
        //将所有的数异或起来
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        //获得ret中最低位的1
        int mask = 1;
        // mask = k & (-k) 这种方法也可以得到mask
        while ((mask & ret) == 0) {
            mask <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int n : nums) {
            if ((mask & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

}
