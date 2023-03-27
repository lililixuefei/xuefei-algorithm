package leetcode.daily;

/**
 * @description: 统计只差一个字符的子串数目
 * @author: xuefei
 * @date: 2023/03/27 21:48
 */
public class CountSubstrings {

	public int countSubstrings(String s, String t) {
		char[] sChars = s.toCharArray();
		char[] tChars = t.toCharArray();
		int ans = 0;
		int n = sChars.length;
		int m = tChars.length;
		for (int d = 1 - m; d < n; ++d) { // d=i-j, j=i-d
			int i = Math.max(d, 0);
			for (int k0 = i - 1, k1 = k0; i < n && i - d < m; ++i) {
				if (sChars[i] != tChars[i - d]) {
					k0 = k1; // 上上一个不同
					k1 = i;  // 上一个不同
				}
				ans += k1 - k0;
			}
		}
		return ans;
	}


	public int countSubstrings_enumerate(String s, String t) {
		int m = s.length();
		int n = t.length();
		int ans = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int diff = 0;
				for (int k = 0; i + k < m && j + k < n; k++) {
					diff += s.charAt(i + k) == t.charAt(j + k) ? 0 : 1;
					if (diff > 1) {
						break;
					} else if (diff == 1) {
						ans++;
					}
				}
			}
		}
		return ans;
	}


}
