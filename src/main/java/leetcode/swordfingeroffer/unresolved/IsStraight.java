package leetcode.swordfingeroffer.unresolved;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 剑指 Offer 61. 扑克牌中的顺子
 * @author: xuefei
 * @date: 2023/07/30 17:39
 */
public class IsStraight {

    public boolean isStraight(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num == 0) {
                // 小王不用管
                continue;
            }
            if (numSet.contains(num)) {
                // 出现重复，不可能是顺子
                return false;
            }
            numSet.add(num);

            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        // 考虑到大小王，只要差小于 4 就一定可以凑出顺子
        return max - min <= 4;
    }

}
