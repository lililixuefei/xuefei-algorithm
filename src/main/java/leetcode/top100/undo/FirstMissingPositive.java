package leetcode.top100.undo;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 缺失的第一个正整数
 * @author: xuefei
 * @date: 2023/10/27 19:50
 */
public class FirstMissingPositive {

    public int firstMissingPositive_l(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public int firstMissingPositive_me(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxValue = 0;
        for (int num : nums) {
            set.add(num);
            maxValue = Math.max(maxValue, num);
        }
        for (int i = 1; i <= maxValue; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return maxValue + 1;
    }

}
