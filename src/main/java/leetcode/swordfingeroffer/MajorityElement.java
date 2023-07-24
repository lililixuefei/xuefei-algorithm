package leetcode.swordfingeroffer;

/**
 * @description: 剑指 Offer 39. 数组中出现次数超过一半的数字
 * @author: xuefei
 * @date: 2023/07/24 23:48
 */
public class MajorityElement {

	public static int majorityElement(int[] nums) {
		int count = 0;
		Integer candidate = null;

		for (int num : nums) {
			if (count == 0) {
				candidate = num;
			}
			count += ((num == candidate) ? 1 : -1);
		}

		return candidate;
	}

}
