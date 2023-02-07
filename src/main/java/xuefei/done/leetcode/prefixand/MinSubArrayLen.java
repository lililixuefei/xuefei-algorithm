package xuefei.done.leetcode.prefixand;

import java.util.*;

/**
 * @description: 长度最小的子数组
 * @author: xuefei
 * @date: 2023/02/02 22:56
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 2, 3, 5};
        System.out.println(minSubArrayLen(6, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int minSubArrayLen = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum = sum + nums[right];
            while (sum >= target) {
                minSubArrayLen = Math.min(minSubArrayLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minSubArrayLen == Integer.MAX_VALUE ? 0 : minSubArrayLen;
    }

    public static int minSubArrayLen2(int target, int[] nums) {
        // 构建前缀和数组
        int[] preNums = buildPreNums(nums);
        int minSubArrayLen = Integer.MAX_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            int num = target + preNums[i - 1];
            int index = Arrays.binarySearch(preNums, num);
            if (index < 0) {
                index = -index - 1;
            }
            if (index <= nums.length) {
                minSubArrayLen = Math.min(minSubArrayLen, index - (i - 1));
            }
        }
        return minSubArrayLen == Integer.MAX_VALUE ? 0 : minSubArrayLen;
    }


    public static int minSubArrayLen1(int target, int[] nums) {
        // 构建前缀和数组
        int[] preNums = buildPreNums(nums);
        int minSubArrayLen = Integer.MAX_VALUE;
        for (int i = 0; i < preNums.length; i++) {
            for (int j = i + 1; j < preNums.length; j++) {
                if (j - i >= minSubArrayLen) {
                    break;
                }
                if (preNums[j] - preNums[i] >= target) {
                    minSubArrayLen = Math.min(minSubArrayLen, (j - i));
                    break;
                }
            }
        }
        return minSubArrayLen == Integer.MAX_VALUE ? 0 : minSubArrayLen;
    }

    private static int[] buildPreNums(int[] nums) {
        int[] preNums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            preNums[i] = preNums[i - 1] + nums[i - 1];
        }
        return preNums;
    }
}
