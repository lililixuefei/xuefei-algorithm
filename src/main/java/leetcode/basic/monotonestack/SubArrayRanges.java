package leetcode.basic.monotonestack;


/**
 * @description: 子数组范围和
 * @author: xuefei
 * @date: 2023/02/24 22:52
 */
public class SubArrayRanges {

	public static void main(String[] args) {
		int[] nums = new int[]{4, -2, -3, 4, 1};
		System.out.println(subArrayRanges(nums));
	}


	public static long subArrayRanges(int[] nums) {
		int n = nums.length;
		long res = 0;
		for (int i = 0; i < n; i++) {
			int minVal = Integer.MAX_VALUE;
			int maxVal = Integer.MIN_VALUE;
			for (int j = i; j < n; j++) {
				minVal = Math.min(minVal, nums[j]);
				maxVal = Math.max(maxVal, nums[j]);
				res += maxVal - minVal;
			}
		}
		return res;
	}

}
