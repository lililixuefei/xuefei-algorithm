package leetcode.study_plan.binary_search;

/**
 * @description: 搜索插入位置   https://leetcode.cn/problems/search-insert-position/
 * @author: xuefei
 * @date: 2022/05/15 15:26
 */
public class SearchInsert {

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums, 2));
    }


    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }



    public static int searchInsert1(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        if (target > nums[nums.length-1]){
            return nums.length;
        }

        if (target < nums[0]){
            return 0;
        }

        while (low <= high){
            int mid  = (high - low) / 2 + low;
            if (nums[mid] > target && nums[mid - 1] < target){
                return mid;
            }
            if (nums[mid] < target && nums[mid + 1] > target){
                return mid + 1;
            }
            if (nums[mid] > target){
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }else {
                return mid;
            }
        }
        return nums.length;
    }
}
