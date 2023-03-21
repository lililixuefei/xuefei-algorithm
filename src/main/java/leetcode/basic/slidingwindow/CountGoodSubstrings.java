package leetcode.basic.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 长度为三且各字符不同的子字符串
 * @author: xuefei
 * @date: 2023/03/21 22:02
 */
public class CountGoodSubstrings {

	public int countGoodSubstrings(String s) {
		Map<Character, Integer> window = new HashMap<>();
		int res = 0;
		int right = 0;
		int left = 0;
		while (right < s.length()) {
			char r = s.charAt(right++);
			window.put(r, window.getOrDefault(r, 0) + 1);
			while (right - left == 3) {
				if (window.entrySet().stream().filter(e -> e.getValue() == 1).count() == 3) {
					res++;
				}
				char l = s.charAt(left++);
				window.put(l, window.get(l) - 1);
			}
		}
		return res;
	}

}
