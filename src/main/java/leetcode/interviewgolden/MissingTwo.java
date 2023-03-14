package leetcode.interviewgolden;


/**
 * @description: 消失的两个数字
 * @author: xuefei
 * @date: 2023/03/14 22:45
 */
public class MissingTwo {

	public int[] missingTwo(int[] nums) {
		if (nums.length <= 0) {
			return new int[]{1, 2};
		}
		int[] newNums = new int[nums.length + 3];
		for (int num : nums) {
			newNums[num] = num;
		}

		int j = 0;
		int[] res = new int[2];
		for (int i = 1; i < newNums.length; i++) {
			if (newNums[i] == 0) {
				res[j++] = i;
			}
		}
		return res;
	}

}
