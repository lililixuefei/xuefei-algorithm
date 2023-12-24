package leetcode.top100.hash;

import java.util.HashMap;

/**
 * @Description 两数之和
 * @Author xuefei
 * @Date 2023/10/28 17:54
 * @Version 1.0
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // 维护 val -> index 的映射
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 查表，看看是否有能和 nums[i] 凑出 target 的元素
            int need = target - nums[i];
            if (valToIndex.containsKey(need)) {
                return new int[]{i, valToIndex.get(need)};
            }
            // 存入 val -> index 的映射
            valToIndex.put(nums[i], i);
        }
        return null;
    }

}
