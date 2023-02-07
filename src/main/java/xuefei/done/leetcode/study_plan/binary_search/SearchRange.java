package xuefei.done.leetcode.study_plan.binary_search;


import java.util.Arrays;

/**
 * @description: 在排序数组中查找元素的第一个和最后一个位置   https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @author: xuefei
 * @date: 2022/05/18 23:55
 */
public class SearchRange {


    public static void main(String[] args) {

        int[] nums = {1};
        System.out.println(Arrays.toString(searchRange(nums, 1)));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = nums.length - 1;
        int[] ans = new int[]{-1, -1};

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                int copyMid1 = mid;
                int copyMid2 = mid;
                while (copyMid1 <= right && nums[copyMid1] == target) {
                    ans[1] = copyMid1;
                    copyMid1++;
                }

                while (copyMid2 >= left && copyMid2 <= right && nums[copyMid2] == target) {
                    ans[0] = copyMid2;
                    copyMid2--;
                }
                break;
            }
        }
        return ans;
    }
}
