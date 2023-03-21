package leetcode.basic.slidingwindow;

/**
 * @description: 得到 K 个黑块的最少涂色次数
 * @author: xuefei
 * @date: 2023/03/21 22:47
 */
public class MinimumRecolors {

	public int minimumRecolors(String blocks, int k) {
		int[] nums = new int[blocks.length()];
		for (int i = 0; i < blocks.length(); i++) {
			if (blocks.charAt(i) == 'B') {
				nums[i] = 1;
			} else {
				nums[i] = 0;
			}
		}
		int left = 0;
		int right = 0;
		int ans = Integer.MIN_VALUE;
		int cur = 0;
		while (right < nums.length) {
			cur += nums[right];
			while (right - left >= k - 1) {
				ans = Math.max(ans, cur);
				cur -= nums[left++];
			}
			right++;
		}
		return k - ans;
	}

}
