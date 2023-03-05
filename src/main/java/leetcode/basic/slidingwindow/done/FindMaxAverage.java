package leetcode.basic.slidingwindow.done;

/**
 * @description: 子数组最大平均数 I
 * @author: xuefei
 * @date: 2023/02/22 22:57
 */
public class FindMaxAverage {

    public static void main(String[] args) {
        int[] nums = new int[]{-1};
        System.out.println(findMaxAverage(nums, 1));
    }

    public static double findMaxAverage(int[] nums, int k) {
        double ans = -100000000;
        double sum = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= k - 1) {
                sum += nums[i];
                double p = sum / k;
                ans = Math.max(ans, p);
                sum -= nums[index++];
            } else {
                sum += nums[i];
            }
        }
        return ans;
    }

    /**
     * 官方题解
     *
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage2(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }

}
