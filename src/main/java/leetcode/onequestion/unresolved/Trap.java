package leetcode.onequestion.unresolved;

/**
 * @description: 接雨水
 * @author: xuefei
 * @date: 2023/07/23 22:43
 */
public class Trap {

	int trap(int[] height) {
		int n = height.length;
		int res = 0;
		for (int i = 1; i < n - 1; i++) {
			int l_max = 0;
			int r_max = 0;
			// 找右边最高的柱子
			for (int j = i; j < n; j++) {
				r_max = Math.max(r_max, height[j]);
			}
			// 找左边最高的柱子
			for (int j = i; j >= 0; j--) {
				l_max = Math.max(l_max, height[j]);
			}
			// 如果自己就是最高的话，
			// l_max == r_max == height[i]
			res += Math.min(l_max, r_max) - height[i];
		}
		return res;
	}


}
