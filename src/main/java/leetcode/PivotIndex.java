package leetcode;

/**
 * @description: 寻找数组的中心下标   https://leetcode.cn/problems/find-pivot-index/
 * @author: xuefei
 * @date: 2022/06/26 19:49
 */
public class PivotIndex {

    public static void main(String[] args) {

        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }


    public static int pivotIndex(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int l = 0; l < i; l++) {
                leftSum += nums[l];
            }

            for (int r = i + 1; r < length; r++) {
                rightSum += nums[r];
            }

            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}
