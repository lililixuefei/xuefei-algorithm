package me.daily;

import java.util.Arrays;

/**
 * @description: 排序
 * @author: xuefei
 * @date: 2022/10/10 22:49
 */
public class Sort {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        quickSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    /**
     * 快排
     *
     * @param arr
     * @return
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
        int m = partition(arr, l, r);
        quickSort(arr, l, m - 1);
        quickSort(arr, m + 1, r);
    }

    private static int partition(int[] arr, int l, int r) {
        // base case
        if (l == r) {
            return l;
        }

        int lessEqual = l - 1;
        while (l < r) {
            if (arr[l] < arr[r]) {
                swap(arr, l, ++lessEqual);
            }
            l++;
        }
        swap(arr, ++lessEqual, r);

        return lessEqual;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
