package leetcode.interviewgolden;


/**
 * @description: 消失的两个数字
 * @author: xuefei
 * @date: 2023/03/14 22:45
 */
public class MissingTwo {

	public int[] missingTwo_good(int[] nums) {
		int xorsum = 0;
		int n = nums.length + 2;
		for (int num : nums) {
			xorsum ^= num;
		}
		for (int i = 1; i <= n; i++) {
			xorsum ^= i;
		}
		// 防止溢出
		int lsb = (xorsum == Integer.MIN_VALUE ? xorsum : xorsum & (-xorsum));
		int type1 = 0, type2 = 0;
		for (int num : nums) {
			if ((num & lsb) != 0) {
				type1 ^= num;
			} else {
				type2 ^= num;
			}
		}
		for (int i = 1; i <= n; i++) {
			if ((i & lsb) != 0) {
				type1 ^= i;
			} else {
				type2 ^= i;
			}
		}
		return new int[]{type1, type2};
	}


	public int[] missingTwo_me(int[] nums) {
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
