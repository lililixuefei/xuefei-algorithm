package leetcode.interviewgolden.unresolved;

/**
 * @Description 搜索旋转数组
 * @Author xuefei
 * @Date 2023/9/16 12:04
 * @Version 1.0
 */
public class Search {

    public int search(int[] arr, int target) {
        if (arr[0] == target) {
            return 0;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] == target) {
                while (mid > 1 && arr[mid - 1] == arr[mid]) {
                    mid--;
                }
                return mid;
            } else if (arr[mid] > arr[left]) {
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (arr[mid] < arr[left]) {
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                left++;
            }
        }
        return -1;
    }


}
