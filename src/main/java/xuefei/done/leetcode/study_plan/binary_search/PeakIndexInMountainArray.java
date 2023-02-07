package xuefei.done.leetcode.study_plan.binary_search;

/**
 * @description: 山脉数组的峰顶索引   https://leetcode.cn/problems/peak-index-in-a-mountain-array/
 * @author: xuefei
 * @date: 2022/05/15 15:44
 */
public class PeakIndexInMountainArray {

    public static void main(String[] args) {

    }

    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int left = 1, right = n - 2, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


    public static int peakIndexInMountainArray1(int[] arr) {

        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[max] < arr[i]){
                max = i;
            }
        }
        return max;
    }
}
