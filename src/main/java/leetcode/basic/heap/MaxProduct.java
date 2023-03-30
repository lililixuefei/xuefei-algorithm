package leetcode.basic.heap;

import java.util.Arrays;

/**
 * @description: 数组中两元素的最大乘积
 * @author: xuefei
 * @date: 2023/03/30 23:17
 */
public class MaxProduct {

	public static void main(String[] args) {
		maxProduct_2(new int[]{1,2});
	}

	public static int maxProduct_2(int[] nums) {
		int a = -1;
		int b = -1;
		for (int x : nums) {
			if (x > a) {
				b = a;
				a = x;
			} else if (x > b) {
				b = x;
			}
		}
		return (a - 1) * (b - 1);
	}


	public int maxProduct_1(int[] nums) {
		Arrays.sort(nums);
		return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
	}


}
