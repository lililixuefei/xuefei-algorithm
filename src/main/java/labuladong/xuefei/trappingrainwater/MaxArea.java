package labuladong.xuefei.trappingrainwater;

/**
 * @description: 11. 盛最多水的容器
 * @author: xuefei
 * @date: 2023/07/23 23:12
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

	public int maxArea2(int[] height) {
		int left = 0, right = height.length - 1;
		int res = 0;
		while (left < right) {
			// [left, right] 之间的矩形面积
			int cur_area = Math.min(height[left], height[right]) * (right - left);
			res = Math.max(res, cur_area);
			// 双指针技巧，移动较低的一边
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return res;
	}

}
