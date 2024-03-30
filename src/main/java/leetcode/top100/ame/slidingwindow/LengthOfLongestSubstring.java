package leetcode.top100.ame.slidingwindow;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/30 17:31
 * @Version 1.0
 */
public class LengthOfLongestSubstring {

	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> window = new HashMap<>();
		int ans = Integer.MIN_VALUE;
		int left = 0;
		int right = 0;
		while (right < s.length()) {
			char c = s.charAt(right);
			right++;
			window.put(c, (window.getOrDefault(c, 0) + 1));
			while (window.getOrDefault(c, 0) > 1) {
				window.put(s.charAt(left), (window.get(s.charAt(left)) - 1));
				left++;
			}
			ans = Math.max(ans, right - left);
		}
		return ans;
	}

}
