package xuefei.labuladong.sort;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/02/19 15:04
 */
public class MergeSort {

    // 定义：排序 nums[lo..hi]
    void sort(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        // 利用定义，排序 nums[lo..mid]
        sort(nums, lo, mid);
        // 利用定义，排序 nums[mid+1..hi]
        sort(nums, mid + 1, hi);

        // 后序位置
        // 此时两部分子数组已经被排好序
        // 合并两个有序数组，使 nums[lo..hi] 有序
        merge(nums, lo, mid, hi);
    }


    // 将有序数组 nums[lo..mid] 和有序数组 nums[mid+1..hi]
    public static void merge(int[] arr, int lo, int mid, int hi) {
        int[] help = new int[hi - lo + 1];
        int i = 0;
        int p1 = lo;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= hi) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 要么p1越界了，要么p2越界了
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= hi) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[lo + i] = help[i];
        }
    }
}
