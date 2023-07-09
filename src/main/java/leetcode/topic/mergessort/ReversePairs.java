package leetcode.topic.mergessort;

/**
 * @description: 翻转对
 * @author: xuefei
 * @date: 2023/07/09 16:15
 */
public class ReversePairs {

	public int reversePairs(int[] nums) {
		return process(nums, 0, nums.length - 1);
	}

	public int process(int[] nums, int l, int r) {
		if (l == r) {
			return 0;
		}
		int m = l + ((r - l) >> 1);
		return process(nums, l, m) +
				process(nums, m + 1, r) +
				merge(nums, l, m, r);
	}

	private int merge(int[] arr, int l, int m, int r) {
		// [l....M] [M+1....R]
		int ans = 0;
		// 目前囊括进来的数，是从[M+1, windowR)
		int windowR = m + 1;
		for (int i = l; i <= m; i++) {
			while (windowR <= r && (long) arr[i] > (long) arr[windowR] * 2) {
				windowR++;
			}
			ans += windowR - m - 1;
		}
		int[] help = new int[r - l + 1];
		int i = 0;
		int p1 = l;
		int p2 = m + 1;
		while (p1 <= m && p2 <= r) {
			help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= m) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[l + i] = help[i];
		}
		return ans;
	}

}
