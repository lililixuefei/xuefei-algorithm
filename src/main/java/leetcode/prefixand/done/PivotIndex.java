package leetcode.prefixand.done;

/**
 * @description: 左右两边子数组的和相等
 * @author: xuefei
 * @date: 2023/02/21 23:08
 */
public class PivotIndex {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }

        for (int i = 1; i < pre.length; i++) {
            if (pre[i - 1] == pre[n] - pre[i]) {
                return i - 1;
            }
        }
        return -1;
    }

}
