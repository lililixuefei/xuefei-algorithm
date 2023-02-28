package leetcode.doublepointer;

/**
 * @description: 字符的最短距离
 * @author: xuefei
 * @date: 2023/02/28 23:15
 */
public class ShortestToChar {

	public static void main(String[] args) {
		shortestToChar("loveleetcode", 'e');
	}

	public static int[] shortestToChar(String s, char c) {
		int n = s.length();
		int[] ans = new int[n];

		for (int i = 0, idx = -n; i < n; ++i) {
			if (s.charAt(i) == c) {
				idx = i;
			}
			ans[i] = i - idx;
		}

		for (int i = n - 1, idx = 3 * n; i >= 0; --i) {
			if (s.charAt(i) == c) {
				idx = i;
			}
			ans[i] = Math.min(ans[i], idx - i);
		}
		return ans;
	}

}
