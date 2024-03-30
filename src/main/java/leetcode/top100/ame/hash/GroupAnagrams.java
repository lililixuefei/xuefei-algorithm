package leetcode.top100.ame.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/27 21:59
 * @Version 1.0
 */
public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> ans = new ArrayList<>();
		Map<String, List<String>> map = new HashMap() {
		};
		for (String str : strs) {
			String encode = encode(str);
			map.putIfAbsent(encode, new ArrayList());
			map.get(encode).add(str);
		}
		for (List<String> value : map.values()) {
			ans.add(value);
		}
		return ans;
	}

	private String encode(String str) {
		char[] array = new char[26];
		for (int i = 0; i < str.length(); i++) {
			array[str.charAt(i) - 'a']++;
		}
		return new String(array);
	}

}
