package leetcode.onequestion.resolved;

/**
 * @description: 只出现一次的数字
 * @author: xuefei
 * @date: 2023/10/16 18:36
 */
public class SingleNumber {

    public int[] singleNumber(int[] nums) {
        int z = 0;
        for (int num : nums) {
            z = z ^ num;
        }

        int one = 1;
        while ((z & one) == 0) {
            one = one << 1;
        }

        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((one & num) != 0) {
                a = a ^ num;
            } else {
                b = b ^ num;
            }
        }
        return new int[]{a, b};
    }

}
