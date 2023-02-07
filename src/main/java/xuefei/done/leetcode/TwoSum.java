package xuefei.done.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 两数之和  https://leetcode-cn.com/problems/two-sum/
 * @author: xuefei
 * @date: 2022/04/28 22:34
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        for (int i : result) {
            System.out.println(i);
        }
    }

    /**
     * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] goodTwoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length == 1) {
            return result;
        }
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }


    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length == 1) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == dif) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
}
