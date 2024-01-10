package labuladong.review.sort;

/**
 * @description:
 * @author: xuefei
 * @date: 2024/01/09 10:39
 */
public class QuickSort {


    public void quickSort(int[] nums) {
        process(nums, 0, nums.length - 1);
    }


    private void process(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = partition(nums, l, r);
        process(nums, l, m - 1);
        process(nums, m + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        int less = l - 1;
        while (l < r) {
            if (nums[l] <= nums[r]) {
                swap(nums, ++less, l);
            }
            l++;
        }
        swap(nums, ++less, r);
        return less;
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

}
