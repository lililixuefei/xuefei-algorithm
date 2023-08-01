package leetcode.onequestion.unresolved;

import java.util.Arrays;

/**
 * @description: 英雄的力量
 * @author: xuefei
 * @date: 2023/08/01 00:19
 */
public class SumOfPower {

    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        int dp;
        int preSum = 0;
        int res = 0;
        int mod = 1000000007;
        for (int i = 0; i < nums.length; i++) {
            dp = (nums[i] + preSum) % mod;
            preSum = (preSum + dp) % mod;
            System.out.println(dp);
            res = (int) ((res + (long) nums[i] * nums[i] % mod * dp) % mod);
            if (res < 0) {
                res += mod;
            }
        }
        return res;
    }


}
