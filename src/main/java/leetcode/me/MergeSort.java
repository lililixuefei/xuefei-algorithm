package leetcode.me;

import java.util.Arrays;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/10/27 15:51
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 7, 8, 43, 1, 4, 7, 7, 8, 3, 1, 3};
        mergeSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }

    }

    public static int[] mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        process(nums, 0, nums.length - 1);
        return nums;

    }

    public static void process(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + (r - l) / 2;
        process(nums, l, mid);
        process(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    private static void merge(int[] nums, int l, int mid, int r) {
        int[] array = new int[r - l + 1];

        int i = 0;
        int j = l;
        int p = mid + 1;
        while (j <= mid && p <= r) {
            array[i++] = nums[j] <= nums[p] ? nums[j++] : nums[p++];
        }
        while (j <= mid) {
            array[i++] = nums[j++];
        }
        while (p <= r) {
            array[i++] = nums[p++];
        }

        for (int m = l; m <= r; m++) {
            nums[m] = array[m - l];
        }
    }

}
