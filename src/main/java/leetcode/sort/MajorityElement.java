package leetcode.sort;

import java.util.Arrays;

/**
 * @description: 多数元素
 * @author: xuefei
 * @date: 2023/02/25 17:46
 */
public class MajorityElement {

	public static void main(String[] args) {
		int[] nums = new int[]{3, 2, 3};
		System.out.println(majorityElement_good(nums));
	}

	public static int majorityElement_good(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}


	public static int majorityElement_me(int[] nums) {
		Arrays.sort(nums);
		int value = nums[0];
		int ans = 1;
		int maxAns = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				ans++;
				if (ans > maxAns) {
					value = nums[i];
					maxAns = ans;
				}
			} else {
				ans = 1;
			}
		}
		return value;
	}

}
