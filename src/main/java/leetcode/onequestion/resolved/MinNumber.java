package leetcode.onequestion.resolved;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 从两个数字数组里生成最小数字
 * @author: xuefei
 * @date: 2023/09/05 23:13
 */
public class MinNumber {

    public int minNumber(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        int minNum1 = Integer.MAX_VALUE;
        int minNum2 = Integer.MAX_VALUE;
        for (int num : nums1) {
            minNum1 = Math.min(num, minNum1);
            set.add(num);
        }

        int ans = Integer.MAX_VALUE;
        for (int num : nums2) {
            minNum2 = Math.min(num, minNum2);
            if (set.contains(num) && num < ans) {
                ans = num;
            }
        }

        if (ans != Integer.MAX_VALUE) {
            return ans;
        }
        return minNum1 < minNum2 ? minNum1 * 10 + minNum2 : minNum2 * 10 + minNum1;
    }

}
