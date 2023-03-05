package leetcode.basic.prefixand;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 连续数组
 * @author: xuefei
 * @date: 2023/02/21 23:23
 */
public class FindMaxLength {

    public int findMaxLength(int[] nums) {
        int maxLen = 0;
        int counter = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; ++i) {
            counter += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(counter)) {
                int prevIndex = map.get(counter);
                maxLen = Math.max(maxLen, i - prevIndex);
            } else {
                map.put(counter, i);
            }
        }
        return maxLen;
    }

}
