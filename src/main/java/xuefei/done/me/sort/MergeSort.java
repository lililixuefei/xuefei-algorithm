package xuefei.done.me.sort;

/**
 * @description: 归并排序
 * @author: xuefei
 * @date: 2022/09/02 00:25
 */
public class MergeSort {

    public static void main(String[] args) {

    }

    /**
     * 归并排序
     *
     * @param nums
     * @return
     */
    private void process(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(nums, l, mid);
        process(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];

        int i = 0;
        int j = l;
        int k = mid + 1;
        while (j <= mid && k <= r) {
            temp[i++] = nums[j] < nums[k] ? nums[j++] : nums[k++];
        }

        while (j <= mid) {
            temp[i++] = nums[j++];
        }
        while (k <= r) {
            temp[i++] = nums[k++];
        }

        for (int m = 0; m < temp.length; m++) {
            nums[l + m] = temp[m];
        }
    }
}
