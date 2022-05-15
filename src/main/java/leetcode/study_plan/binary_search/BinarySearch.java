package leetcode.study_plan.binary_search;

/**
 * @description: 二分查找  https://leetcode.cn/problems/binary-search/
 * @author: xuefei
 * @date: 2022/05/14 17:03
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(nums, 9));
    }

    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
