package leetcode.top100.ame.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/30 17:58
 * @Version 1.0
 */
public class FindAnagrams {

	public static void main(String[] args) {
		findAnagrams("baa","aa");
	}

	public static List<Integer> findAnagrams(String s, String p) {
		Map<Character, Integer> window = new HashMap<>();
		Map<Character, Integer> need = new HashMap<>();
		for (int i = 0; i < p.length(); i++) {
			need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
		}
		int left = 0;
		int right = 0;
		int valid = 0;
		List<Integer> ans = new ArrayList<>();
		while (right < s.length()) {
			char c = s.charAt(right);
			right++;

			window.put(c, window.getOrDefault(c, 0) + 1);
			if (need.containsKey(c)) {
				if (window.get(c).equals(need.get(c))) {
					valid++;
				}
			}
			while (right - left >= p.length()) {
				if (valid == need.size()) {
					ans.add(left);
				}
				char lc = s.charAt(left);
				if (window.get(lc).equals(need.get(lc))) {
					valid--;
				}
				window.put(lc, window.getOrDefault(lc, 0) - 1);
				left++;
			}
		}
		return ans;
	}

}
