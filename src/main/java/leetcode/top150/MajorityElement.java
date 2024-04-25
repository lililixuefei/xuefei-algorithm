package leetcode.top150;

import java.util.Arrays;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/25 22:33
 * @Version 1.0
 */
public class MajorityElement {


    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    public int majorityElement2(int[] nums) {
        int target = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                target = num;
                count = 1;
            } else if (target == num) {
                count++;
            } else {
                count--;
            }
        }
        return target;

    }


}
