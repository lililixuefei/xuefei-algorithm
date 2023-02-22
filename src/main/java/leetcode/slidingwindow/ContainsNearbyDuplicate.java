package leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

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

}
