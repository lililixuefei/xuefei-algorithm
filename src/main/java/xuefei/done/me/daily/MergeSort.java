package xuefei.done.me.daily;

import java.util.Arrays;

/**
 * @description: 归并排序
 * @author: xuefei
 * @date: 2022/10/13 22:58
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {6, 5, 7, 4, 5, 1};
        mergeSort(arr);
        Arrays.stream(arr).forEach(System.out::println);

    }

    /**
     * 归并排序
     *
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + (r - l) / 2;
        // 左边有序
        process(arr, l, mid);
        // 右边有序
        process(arr, mid + 1, r);
        // 合并
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }

        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[l++] = help[i];
        }
    }
}
