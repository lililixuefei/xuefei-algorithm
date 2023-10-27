package leetcode.me;


/**
 * @description:
 * @author: xuefei
 * @date: 2023/10/27 16:05
 */
public class QuickSort {

    public static void main(String[] args) {

//        int[] nums = {1, 3, 5, 7, 8, 43, 1, 4, 7, 7, 8, 3, 1, 3};
        int[] nums = {0, 4, 3, 1, 2, 3};
        quickSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }

    }

    public static int[] quickSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        process(nums, 0, nums.length - 1);
        return nums;
    }

    private static void process(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = partition(nums, l, r);
        process(nums, l, mid - 1);
        process(nums, mid + 1, r);

    }

    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lessEqual = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }
        swap(arr, ++lessEqual, R);
        return lessEqual;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
