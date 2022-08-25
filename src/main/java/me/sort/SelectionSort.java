package me.sort;


/**
 * @description: 选择排序
 * @author: xuefei
 * @date: 2022/08/25 23:23
 */
public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = {5,2,3,1};
        selectionSort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                min = arr[j] < arr[min] ? j : min;
            }
            if (min == i){
                continue;
            }
            swap(arr, i, min);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
