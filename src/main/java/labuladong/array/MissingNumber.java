package labuladong.array;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/7/11 10:43 AM
 * @Version 1.0
 */
public class MissingNumber {

	int missingNumber3(int[] nums) {
		int n = nums.length;
		int res = 0;
		// 新补的索引
		res += n;
		// 剩下索引和元素的差加起来
		for (int i = 0; i < n; i++) {
			res += i - nums[i];
		}
		return res;
	}

	int missingNumber2(int[] nums) {
		int n = nums.length;
		// 公式：(首项 + 末项) * 项数 / 2
		int expect = (0 + n) * (n + 1) / 2;

		int sum = 0;
		for (int x : nums) {
			sum += x;
		}
		return expect - sum;
	}


	int missingNumber(int[] nums) {
		int n = nums.length;
		int res = 0;
		// 先和新补的索引异或一下
		res ^= n;
		// 和其他的元素、索引做异或
		for (int i = 0; i < n; i++) {
			res ^= i ^ nums[i];
		}
		return res;
	}

}
