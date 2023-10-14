package labuladong.array.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/7/11 10:52 AM
 * @Version 1.0
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        // 一左一右两个指针相向而行
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                // 题目要求的索引是从 1 开始的
                return new int[]{nums[left], nums[right]};
            } else if (sum < target) {
                left++; // 让 sum 大一点
            } else {
                right--; // 让 sum 小一点
            }
        }
        return new int[]{-1, -1};
    }


    List<List<Integer>> twoSumTarget(int[] nums, int target) {
        // 先对数组排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            // 根据 sum 和 target 的比较，移动左右指针
            if (sum < target) {
                lo++;
            } else if (sum > target) {
                hi--;
            } else {
                List<Integer> cur = new ArrayList<>();
                cur.add(nums[lo]);
                cur.add(nums[hi]);
                res.add(cur);
                lo++;
                hi--;
            }
        }
        return res;
    }

    List<List<Integer>> twoSumTarget2(int[] nums, int target) {
        // 先对数组排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            int left = nums[lo], right = nums[hi];

            // 根据 sum 和 target 的比较，移动左右指针
            if (sum < target) {
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
            } else if (sum > target) {
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            } else {
                List<Integer> cur = new ArrayList<>();
                cur.add(nums[lo]);
                cur.add(nums[hi]);
                res.add(cur);
                // 跳过所有重复的元素
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            }
        }
        return res;
    }

}
