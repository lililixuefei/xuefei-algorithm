package xuefei.done.leetcode.study_plan.programme_ability;

import java.util.Arrays;

/**
 * @description: 三角形的最大周长   https://leetcode.cn/problems/largest-perimeter-triangle/
 * @author: xuefei
 * @date: 2022/05/18 00:09
 */
public class LargestPerimeter {

    public static void main(String[] args) {

    }


    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; --i) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }
}
