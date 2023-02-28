package leetcode.doublepointer;

/**
 * @description: 翻转图像
 * @author: xuefei
 * @date: 2023/02/28 22:21
 */
public class FlipAndInvertImage {

	public int[][] flipAndInvertImage(int[][] image) {
		for (int[] ints : image) {
			// 翻转图像
			flipRow(ints);
		}
		return image;
	}

	private void flipRow(int[] nums) {
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			nums[i] = nums[i] == 1 ? 0 : 1;
		}
		// 翻转行
		int j = 0;
		int l = length - 1;
		while (j < l) {
			int temp = nums[j];
			nums[j++] = nums[l];
			nums[l--] = temp;
		}
	}

}
