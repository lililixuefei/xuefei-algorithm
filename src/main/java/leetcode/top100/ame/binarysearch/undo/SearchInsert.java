package leetcode.top100.ame.binarysearch.undo;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/17 22:31
 * @Version 1.0
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = (r + l) / 2;
            if (nums[mid] > target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    // 示例 1:
    //
    //输入: nums = [1,3,5,6], target = 5
    //输出: 2
    //示例 2:
    //
    //输入: nums = [1,3,5,6], target = 2
    //输出: 1
    //示例 3:
    //
    //输入: nums = [1,3,5,6], target = 7
    //输出: 4

}
