package leetcode.prefixand.done;

/**
 * @description: 逐步求和得到正数的最小值
 * @author: xuefei
 * @date: 2023/02/21 21:40
 */
public class MinStartValue {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,5,-5,-1};
        System.out.println(minStartValue(nums));
    }

    public static int minStartValue2(int[] nums) {
        int value = 0;
        int pre = 0;
        for (int i = 1; i <= nums.length; i++) {
            pre = pre + nums[i - 1];
            value = Math.min(pre, value);
        }
        return -value + 1;
    }

    public static int minStartValue(int[] nums) {
        int[] pre = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            pre[i] = nums[i - 1] + pre[i - 1];
        }

        int value = Integer.MAX_VALUE;
        for (int i : pre) {
            value = Math.min(value, i);
        }
        return value <= 0 ? -value + 1 : value;
    }
}
