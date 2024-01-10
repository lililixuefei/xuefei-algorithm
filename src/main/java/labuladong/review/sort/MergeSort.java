package labuladong.review.sort;

/**
 * @description:
 * @author: xuefei
 * @date: 2024/01/09 10:29
 */
public class MergeSort {


    public int[] mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        process(nums, 0, nums.length - 1);
        return nums;
    }

    private void process(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = l + (r - l) / 2;
        process(nums, l, m);
        process(nums, m + 1, r);
        merge(nums, l, m, r);
    }

    private void merge(int[] nums, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p0 = l;
        int p1 = m + 1;
        while (p0 <= m && p1 <= r) {
            help[i++] = nums[p0] <= nums[p1] ? nums[p0++] : nums[p1++];
        }
        while (p0 <= m) {
            help[i++] = nums[p0++];
        }
        while (p1 <= r) {
            help[i++] = nums[p1++];
        }
        for (i = 0; i < help.length; i++) {
            nums[i + l] = help[i];
        }
    }

}
