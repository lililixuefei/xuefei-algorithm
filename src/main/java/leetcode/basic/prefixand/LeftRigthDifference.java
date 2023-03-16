package leetcode.basic.prefixand;

/**
 * @description: 左右元素和的差值
 * @author: xuefei
 * @date: 2023/03/16 22:36
 */
public class LeftRigthDifference {

	public static void main(String[] args) {
		leftRigthDifference(new int[]{10, 4, 8, 3});
	}

	public static int[] leftRigthDifference(int[] nums) {
		int[] leftAnd = new int[nums.length];
		leftAnd[0] = 0;
		for (int i = 1; i < nums.length; i++) {
			leftAnd[i] = leftAnd[i - 1] + nums[i - 1];
		}

		int[] rightAnd = new int[nums.length];
		rightAnd[nums.length - 1] = 0;
		for (int i = nums.length - 2; i >= 0; i--) {
			rightAnd[i] = rightAnd[i + 1] + nums[i + 1];
		}


		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			res[i] = Math.abs(rightAnd[i] - leftAnd[i]);
		}
		return res;
	}

}
