package leetcode.study_plan.binary_search;

import java.util.Arrays;

/**
 * @description: 两个数组间的距离值   https://leetcode.cn/problems/find-the-distance-value-between-two-arrays/
 * @author: xuefei
 * @date: 2022/05/16 22:53
 */
public class FindTheDistanceValue {

    public static void main(String[] args) {

    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int ans = 0;
        for (int num1 : arr1) {
            int low = num1 - d;
            int high = num1 + d;
            if (!binarySearch(arr2, low, high)) {
                ans++;
            }
        }

        return ans;
    }

    public static boolean binarySearch(int[] arr, int low, int high) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= low && arr[mid] <= high) {
                return true;
            } else if (arr[mid] < low) {
                left = mid + 1;
            } else if (arr[mid] > high) {
                right = mid - 1;
            }
        }

        return false;
    }
}
