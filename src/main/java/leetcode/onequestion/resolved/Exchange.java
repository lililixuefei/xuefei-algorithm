package leetcode.onequestion.resolved;

import static labuladong.sort.Code02_PartitionAndQuickSort.swap;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/09/11 15:28
 */
public class Exchange {

    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 3, 1, 5, 7, 9, 0, 7, 53, 4, 10};
        int[] ans = exchange(nums);

        for (int an : ans) {
            System.out.println(an);
        }

    }


    public static int[] exchange(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] % 2 == 1) {
                swap(nums, slow, fast);
                slow++;
            }
            fast++;
        }
        return nums;
    }

}
