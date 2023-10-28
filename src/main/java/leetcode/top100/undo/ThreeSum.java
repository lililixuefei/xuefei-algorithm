package leetcode.top100.undo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 三数之和
 * @Author xuefei
 * @Date 2023/10/28 18:29
 * @Version 1.0
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<List<Integer>> tuples = twoSum2(nums, i + 1, -nums[i]);
            for (List<Integer> cur : tuples) {
                cur.add(nums[i]);
                ans.add(cur);
            }
            // 跳过第一个数字重复的情况，否则会出现重复结果
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return ans;
    }


    public static List<List<Integer>> twoSum2(int[] nums, int start, int target) {
        int L = start;
        int R = nums.length - 1;
        List<List<Integer>> ans = new ArrayList<>();
        while (L < R) {
            int sum = nums[L] + nums[R];
            if (sum > target) {
                R--;
            } else if (sum < target) {
                L++;
            } else { // nums[L] + nums[R] == target
                if (L == start || nums[L - 1] != nums[L]) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[L]);
                    cur.add(nums[R]);
                    ans.add(cur);
                }
                L++;
            }
        }
        return ans;
    }

}
