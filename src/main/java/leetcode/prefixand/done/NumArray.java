package leetcode.prefixand.done;

/**
 * @description: 区域和检索 - 数组不可变
 * @author: xuefei
 * @date: 2023/02/09 23:15
 */
public class NumArray {

    int[] pre;

    public NumArray(int[] nums) {
        pre = new int[nums.length + 1];
        pre[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            pre[i] = nums[i - 1] + pre[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return pre[right + 1] - pre[left];
    }
}
