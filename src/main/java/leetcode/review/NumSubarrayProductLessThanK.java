package leetcode.review;

/**
 * @description: 乘积小于 K 的子数组
 * @author: xuefei
 * @date: 2023/04/05 20:46
 */
public class NumSubarrayProductLessThanK {

	public int numSubarrayProductLessThanK(int[] nums, int k) {
		int ret = 0;
		int prod = 1;
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			prod *= nums[j];
			while (i <= j && prod >= k) {
				prod /= nums[i];
				i++;
			}
			ret += j - i + 1;
		}
		return ret;
	}

}
