package leetcode.basic.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 字符串中的所有变位词
 * @author: xuefei
 * @date: 2023/03/22 22:32
 */
public class FindAnagrams {

	public List<Integer> findAnagrams(String s, String p) {
		Map<Character, Integer> need = new HashMap<>();
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			need.put(c, need.getOrDefault(c, 0) + 1);
		}

		Map<Character, Integer> window = new HashMap<>();
		List<Integer> res = new ArrayList<>();
		int validate = 0;
		int left = 0;
		int right = 0;
		while (right < s.length()) {
			char c = s.charAt(right);
			right++;
			if (need.containsKey(c)) {
				window.put(c, window.getOrDefault(c, 0) + 1);
				if (window.get(c).equals(need.get(c))) {
					validate++;
				}
			}
			while (right - left >= p.length()) {
				if (validate == need.size()) {
					res.add(left);
				}
				char l = s.charAt(left);
				if (need.containsKey(l)) {
					if (window.get(l).equals(need.get(l))) {
						validate--;
					}
					window.put(l, window.get(l) - 1);
				}
				left++;
			}
		}
		return res;
	}

}
