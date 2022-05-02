package zuo;

/**
 * @description: 二分查找
 * @author: xuefei
 * @date: 2022/05/03 01:11
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(binarySearch(arr,6));
    }

    public static int binarySearch(int[] arr, int target) {
        // 边界条件
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                r = mid + 1;
            }
            if (arr[mid] < target) {
                l = mid + 1;
            }
        }
        return -1;
    }
}
