package leetcode.basic.slidingwindow;

/**
 * @description: 找到一个数字的 K 美丽值
 * @author: xuefei
 * @date: 2023/03/21 22:40
 */
public class DivisorSubstrings {

	public int divisorSubstrings(int num, int k) {
		String s = String.valueOf(num);
		int n = s.length();
		int cnt = 0;
		for (int i = 0; i + k <= n; i++) {
			int b = Integer.parseInt(s.substring(i, i + k));
			if (b != 0 && num % b == 0) {
				cnt++;
			}
		}
		return cnt;
	}

}
