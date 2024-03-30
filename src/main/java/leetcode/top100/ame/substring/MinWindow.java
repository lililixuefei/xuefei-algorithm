package leetcode.top100.ame.substring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/30 19:27
 * @Version 1.0
 */
public class MinWindow {

	public String minWindow(String s, String p) {
		Map<Character, Integer> window = new HashMap<>();
		Map<Character, Integer> need = new HashMap<>();
		for (int i = 0; i < p.length(); i++) {
			need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
		}
		int left = 0;
		int right = 0;
		int valid = 0;
		int start = 0;
		int len = Integer.MAX_VALUE;
		while (right < s.length()) {
			char c = s.charAt(right);
			right++;

			window.put(c, window.getOrDefault(c, 0) + 1);
			if (need.containsKey(c)) {
				if (window.get(c).equals(need.get(c))) {
					valid++;
				}
			}
			while (valid == need.size()) {
				if (len > (right - left)) {
					len = right - left;
					start = left;
				}

				char lc = s.charAt(left);
				if (window.get(lc).equals(need.get(lc))) {
					valid--;
				}
				window.put(lc, window.getOrDefault(lc, 0) - 1);
				left++;
			}
		}
		return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
	}

}
