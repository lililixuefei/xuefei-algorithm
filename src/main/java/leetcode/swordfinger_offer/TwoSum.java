package leetcode.swordfinger_offer;

/**
 * @description: 剑指 Offer 57. 和为s的两个数字
 * @author: xuefei
 * @date: 2022/11/13 17:13
 */
public class TwoSum {

    public int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[0];
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r){
            int num1 = nums[l];
            int num2 = nums[r];
            int sum = num1 + num2;
            if (sum == target){
                return new int[]{num1, num2};
            }else if (sum > target){
                r--;
            }else {
                l++;
            }
        }
        return new int[0];
    }

    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[0];
        }
        for (int i = 0; i < nums.length; i++) {
            int ans = target - nums[i];
            if (ans >= 0) {
                int p = binarySearch(nums, i, nums.length - 1, ans);
                if (p > 0) {
                    return new int[]{nums[i], nums[p]};
                }
            }
        }
        return new int[0];
    }

    private int binarySearch(int[] nums, int l, int r, int ans) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == ans) {
                return mid;
            } else if (nums[mid] > ans) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
