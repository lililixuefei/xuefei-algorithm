package leetcode.swordfingeroffer.unresolved;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 剑指 Offer 48. 最长不含重复字符的子字符串
 * @author: xuefei
 * @date: 2023/07/24 23:24
 */
public class LengthOfLongestSubstring {

	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> window = new HashMap<>();
		int left = 0;
		int right = 0;
		int res = 0;
		while (right < s.length()) {
			char c = s.charAt(right);
			right++;
			// 进行窗口内数据的一系列更新
			window.put(c, window.getOrDefault(c, 0) + 1);
			// 判断左侧窗口是否要收缩
			while (window.get(c) > 1) {
				char d = s.charAt(left);
				left++;
				// 进行窗口内数据的一系列更新
				window.put(d, window.get(d) - 1);
			}
			// 在这里更新答案
			res = Math.max(res, right - left);
		}
		return res;
	}

}
