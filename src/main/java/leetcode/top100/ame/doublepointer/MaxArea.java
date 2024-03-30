package leetcode.top100.ame.doublepointer;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/27 22:27
 * @Version 1.0
 */
public class MaxArea {

	public int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int maxArea = 0;
		while (left < right) {
			int minH = Math.min(height[left], height[right]);
			maxArea = Math.max(maxArea, (right - left) * minH);
			if (height[left] <= height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxArea;
	}

}
