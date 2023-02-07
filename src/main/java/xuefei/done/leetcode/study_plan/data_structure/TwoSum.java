package xuefei.done.leetcode.study_plan.data_structure;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 两数之和   https://leetcode.cn/problems/two-sum/
 * @author: xuefei
 * @date: 2022/05/15 20:31
 */
public class TwoSum {

    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] nums, int target) {

        int[] arr = new int[2];
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (hashMap.containsKey(result)){
                arr[0] = hashMap.get(result);
                arr[1] = i;
                return arr;
            }
            hashMap.put(nums[i],i);
        }
        return arr;
    }
}
