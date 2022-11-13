package leetcode.swordfinger_offer;

/**
 * @description: 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * @author: xuefei
 * @date: 2022/11/13 19:32
 */
public class Exchange {

    /**
     * 双指针
     *
     * @param nums
     * @return
     */
    public int[] exchange1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] % 2 == 1) {
                l++;
            } else if (nums[r] % 2 == 0) {
                r--;
            } else {
                swap(nums, l, r);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }


    /**
     * 额外new一个新的数组
     *
     * @param nums
     * @return
     */
    public int[] exchange2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int[] ans = new int[nums.length];
        int l = 0;
        int r = ans.length - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                ans[r--] = num;
            } else {
                ans[l++] = num;
            }
        }
        return ans;
    }
}
