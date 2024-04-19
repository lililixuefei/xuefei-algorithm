package leetcode.top100.binarysearch;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/24 20:10
 * @Version 1.0
 */
public class SearchInsert {


    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();

        // 案例1: 目标值在数组中
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        System.out.println(searchInsert.searchInsert(nums1, target1)); // 输出应为2

        // 案例2: 目标值不在数组中，插入位置在数组中间
        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        System.out.println(searchInsert.searchInsert(nums2, target2)); // 输出应为1

        // 案例3: 目标值不在数组中，插入位置在数组末尾
        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        System.out.println(searchInsert.searchInsert(nums3, target3)); // 输出应为4

        // 案例4: 目标值不在数组中，插入位置在数组开头
        int[] nums4 = {1, 3, 5, 6};
        int target4 = 0;
        System.out.println(searchInsert.searchInsert(nums4, target4)); // 输出应为0

        // 案例5: 空数组
        int[] nums5 = {};
        int target5 = 0;
        System.out.println(searchInsert.searchInsert(nums5, target5)); // 输出应为0
    }


    public int searchInsert(int[] nums, int target) {
        return left_bound(nums, target);
    }


    // 搜索左侧边界的二分算法
    int left_bound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) { // 注意
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return left;
    }

}
