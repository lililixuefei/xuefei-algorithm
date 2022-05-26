package leetcode.hot_100;

/**
 * @description: 只出现一次的数字   https://leetcode.cn/problems/single-number/
 * @author: xuefei
 * @date: 2022/05/27 00:01
 */
public class SingleNumber {

    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
