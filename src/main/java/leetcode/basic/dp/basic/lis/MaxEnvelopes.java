package leetcode.basic.dp.basic.lis;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description: 俄罗斯套娃信封问题
 * @author: xuefei
 * @date: 2023/06/07 23:30
 */
public class MaxEnvelopes {

	public int maxEnvelopes(int[][] envelopes) {
		int n = envelopes.length;
		// 按宽度升序排列，如果宽度一样，则按高度降序排列
		Arrays.sort(envelopes, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
			}
		});
		// 对高度数组寻找 LIS
		int[] height = new int[n];
		for (int i = 0; i < n; i++) {
			height[i] = envelopes[i][1];
		}
		return lengthOfLIS(height);
	}

	public int lengthOfLIS(int[] nums) {
		int piles = 0, n = nums.length;
		int[] top = new int[n];
		for (int i = 0; i < n; i++) {
			int poker = nums[i];
			int left = 0, right = piles;
			// 二分查找插入位置
			while (left < right) {
				int mid = (left + right) / 2;
				if (top[mid] >= poker) {
					right = mid;
				} else {
					left = mid + 1;
				}
			}
			if (left == piles) {
				piles++;
			}
			top[left] = poker;
		}
		return piles;
	}


}
