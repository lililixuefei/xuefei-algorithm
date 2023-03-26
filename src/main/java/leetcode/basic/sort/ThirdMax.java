package leetcode.basic.sort;

import java.util.Arrays;

/**
 * @description: 第三大的数
 * @author: xuefei
 * @date: 2023/03/26 21:07
 */
public class ThirdMax {

	public int thirdMax(int[] nums) {
		nums = Arrays.stream(nums).distinct().sorted().toArray();
		return nums.length < 3 ? nums[nums.length - 1] : nums[nums.length - 3];
	}

}
