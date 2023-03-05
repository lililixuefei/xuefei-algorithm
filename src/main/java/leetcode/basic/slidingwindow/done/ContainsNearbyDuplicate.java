package leetcode.basic.slidingwindow.done;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description: 存在重复元素 II
 * @author: xuefei
 * @date: 2023/02/22 22:46
 */
public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> window = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (window.containsKey(nums[i])) {
                int ans = i - window.get(nums[i]);
                if (ans <= k) {
                    return true;
                }
            }
            window.put(nums[i], i);
        }
        return false;
    }

    /**
     * 滑动窗口
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

}
