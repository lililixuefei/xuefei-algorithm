package leetcode.basic;

/**
 * @description: 二分查找   https://leetcode.cn/problems/binary-search/
 * @author: xuefei
 * @date: 2022/05/27 00:16
 */
public class BinarySearch {

    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] < target){
                left = mid + 1;
            }
            if (nums[mid] > target){
                right = mid - 1;
            }
        }
        return -1;
    }
}
