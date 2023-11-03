package lingcha;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/trapping-rain-water/solutions/1974340/zuo-liao-nbian-huan-bu-hui-yi-ge-shi-pin-ukwm/
 *
 * @Description 接雨水
 * @Author xuefei
 * @Date 2023/10/10 22:28
 * @Version 1.0
 */
public class Trap {

	public int trap3(int[] height) {
		int ans = 0;
		Deque<Integer> st = new ArrayDeque<>();
		for (int i = 0; i < height.length; i++) {
			while (!st.isEmpty() && height[i] >= height[st.peek()]) {
				int bottomH = height[st.pop()];
				if (st.isEmpty()) {
					break;
				}
				int left = st.peek();
				int dh = Math.min(height[left], height[i]) - bottomH; // 面积的高
				ans += dh * (i - left - 1);
			}
			st.push(i);
		}
		return ans;
	}

	public int trap2(int[] height) {
		int ans = 0;
		int left = 0;
		int right = height.length - 1;
		int preMax = 0;
		int sufMax = 0;
		while (left < right) {
			preMax = Math.max(preMax, height[left]);
			sufMax = Math.max(sufMax, height[right]);
			ans += preMax < sufMax ? preMax - height[left++] : sufMax - height[right--];
		}
		return ans;
	}


	public int trap(int[] height) {
		int n = height.length;
		int[] preMax = new int[n]; // preMax[i] 表示从 height[0] 到 height[i] 的最大值
		preMax[0] = height[0];
		for (int i = 1; i < n; i++) {
			preMax[i] = Math.max(preMax[i - 1], height[i]);
		}

		int[] sufMax = new int[n]; // sufMax[i] 表示从 height[i] 到 height[n-1] 的最大值
		sufMax[n - 1] = height[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			sufMax[i] = Math.max(sufMax[i + 1], height[i]);
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans += Math.min(preMax[i], sufMax[i]) - height[i]; // 累加每个水桶能接多少水
		}
		return ans;
	}


}
