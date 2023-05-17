package leetcode.daily;

/**
 * @description: 盛最多水的容器
 * @author: xuefei
 * @date: 2023/05/17 23:22
 */
public class MaxArea {

	public int maxArea(int[] height) {
		int l = 0;
		int r = height.length - 1;
		int maxArea = 0;
		while (l < r) {
			int value = Math.min(height[l], height[r]);
			maxArea = Math.max(maxArea, (r - l) * value);
			if (height[l] > height[r]) {
				r--;
			} else {
				l++;
			}
		}
		return maxArea;
	}

}
