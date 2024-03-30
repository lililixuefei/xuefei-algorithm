package leetcode.top100.ame.doublepointer;

/**
 * @description:
 * @author: xuefei
 * @date: 2024/03/28 17:32
 */
public class Trap {


	public int trap(int[] height) {

		int[] left = new int[height.length];
		int[] right = new int[height.length];

		for (int i = 1; i < height.length; i++) {
			left[i] = Math.max(left[i - 1], height[i - 1]);
		}

		for (int i = height.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], height[i + 1]);
		}

		int value = 0;
		for (int i = 1; i < height.length - 1; i++) {
			int min = Math.min(left[i], right[i]);
			if (min > height[i]) {
				value += (min - height[i]);
			}
		}
		return value;

	}

}
