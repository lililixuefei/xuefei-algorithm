package leetcode.basic.prefixand;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 连续的子数组和
 * @author: xuefei
 * @date: 2023/02/09 23:23
 */
public class CheckSubarraySum {


    public boolean checkSubarraySum(int[] nums, int k) {
        int m = nums.length;
        if (m < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < m; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }


    /**
     * 超时了
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum2(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        int[] pre = new int[nums.length];
        pre[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        for (int i = 1; i < pre.length; i++) {
            for (int j = 0; j < i; j++) {
                int ans = pre[i] - pre[j];
                if (i - j != 1 && ans % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
