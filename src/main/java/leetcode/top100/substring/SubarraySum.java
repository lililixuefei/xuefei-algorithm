package leetcode.top100.substring;

import java.util.HashMap;

/**
 * @Description 和为 K 的子数组
 * @Author xuefei
 * @Date 2023/10/27 0:18
 * @Version 1.0
 */
public class SubarraySum {


    public static void main(String[] args) {
        // 创建一个实例
        SubarraySum solution = new SubarraySum();

        // 测试用例1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("测试用例1的结果：" + solution.subarraySum(nums1, k1)); // 应输出 2

        // 测试用例2
        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("测试用例2的结果：" + solution.subarraySum(nums2, k2)); // 应输出 2

        // 测试用例3
        int[] nums3 = {1, -1, 0};
        int k3 = 0;
        System.out.println("测试用例3的结果：" + solution.subarraySum(nums3, k3)); // 应输出 3
    }


    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // map：前缀和 -> 该前缀和出现的次数
        HashMap<Integer, Integer> preSum = new HashMap<>();
        // base case
        preSum.put(0, 1);

        int res = 0;
        int sum0_i = 0;
        for (int i = 0; i < n; i++) {
            sum0_i += nums[i];
            // 这是我们想找的前缀和 nums[0..j]
            int sum0_j = sum0_i - k;
            // 如果前面有这个前缀和，则直接更新答案
            if (preSum.containsKey(sum0_j)) {
                res += preSum.get(sum0_j);
            }
            // 把前缀和 nums[0..i] 加入并记录出现次数
            preSum.put(sum0_i, preSum.getOrDefault(sum0_i, 0) + 1);
        }
        return res;
    }


}
