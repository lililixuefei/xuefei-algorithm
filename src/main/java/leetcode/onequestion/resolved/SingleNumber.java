package leetcode.onequestion.resolved;

/**
 * @Description 只出现一次的数字
 * @Author xuefei
 * @Date 2023/10/14 13:28
 * @Version 1.0
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans = ans ^ num;
        }
        return ans;
    }

}
