package zuo;

/**
 * @description: 二分查找
 * @author: xuefei
 * @date: 2022/05/03 01:11
 */
public class BinarySearch {


    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6, 7};
//        System.out.println(binarySearch(arr, 6));

        int[] randomArray = randomArray(500, 5);
        for (int i : randomArray) {
            System.out.println(i);
        }
    }

    /**
     * 局部最小
     * @param arr
     * @return
     */
    public static int searchMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return 0;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        int n = arr.length;
        if (arr[n - 1] < arr[n - 2]) {
            return n - 1;
        }
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] < arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid;
            }
            if (arr[mid] > arr[mid - 1]) {
                r = mid - 1;
                continue;
            }
            if (arr[mid] > arr[mid + 1]) {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static int[] randomArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        if (len > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }


    /**
     * 有序数组中找到第一个大于等于target的位置
     *
     * @param arr
     * @param target
     * @return
     */
    public static int mostLeftNoLessNumIndex(int[] arr, int target) {
        // 边界条件
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                r = mid + 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
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
