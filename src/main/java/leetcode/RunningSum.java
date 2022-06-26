package leetcode;

/**
 * @description: 一维数组的动态和   https://leetcode.cn/problems/running-sum-of-1d-array/
 * @author: xuefei
 * @date: 2022/06/26 19:45
 */
public class RunningSum {

    public int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            nums[i] = sum;
        }
        return nums;
    }
}
