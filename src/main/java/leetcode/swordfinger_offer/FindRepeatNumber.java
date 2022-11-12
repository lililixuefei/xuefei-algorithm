package leetcode.swordfinger_offer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @description: 剑指 Offer 03. 数组中重复的数字
 * @author: xuefei
 * @date: 2022/11/12 22:40
 */
public class FindRepeatNumber {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        Arrays.sort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }


    /**
     * 利用hash表 空间复杂度 O(n) 时间复杂度 O(n)
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber_1(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    /**
     * 空间复杂度 O(1) 时间复杂度 O(n)
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber_2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
