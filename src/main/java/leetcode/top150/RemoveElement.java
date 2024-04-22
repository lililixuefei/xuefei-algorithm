package leetcode.top150;


/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/22 23:05
 * @Version 1.0
 */
public class RemoveElement {

    // 3 2 3
    public int removeElement(int[] nums, int val) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] == val) {
                swap(nums, l, r);
                r--;
            } else {
                l++;
            }
        }
        return l;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
