package leetcode.basic.sort;

import java.util.Arrays;

/**
 * @description: 丢失的数字
 * @author: xuefei
 * @date: 2023/02/25 17:59
 */
public class MissingNumber {

	public static void main(String[] args) {
		int[] nums = new int[]{3, 0, 1};
		System.out.println(missingNumber(nums));
	}

	public static int missingNumber(int[] nums) {
		Arrays.sort(nums);

		int temp = 0;
		for (int num : nums) {
			if (num != temp) {
				return temp;
			}
			temp++;
		}
		return temp;
	}

}
