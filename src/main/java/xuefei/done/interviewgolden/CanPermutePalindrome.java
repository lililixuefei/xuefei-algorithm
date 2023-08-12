package xuefei.done.interviewgolden;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description: 回文排列
 * @author: xuefei
 * @date: 2023/03/05 18:52
 */
public class CanPermutePalindrome {

	public static void main(String[] args) {
		canPermutePalindrome_good("aaa");
	}

	public static boolean canPermutePalindrome_good(String s) {
		Set<Character> set = new HashSet<>();
		for (char c : s.toCharArray()) {
			if (!set.add(c)) {
				set.remove(c);
			}
		}
		return set.size() <= 1;
	}


	public static boolean canPermutePalindrome_me(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		if (map.size() == 1) {
			return true;
		}
		boolean res = true;
		int i = 0;
		int j = 0;
		for (Integer value : map.values()) {
			if (value == 1) {
				i++;
				res = i == 1;
				continue;
			}
			if (value % 2 == 1) {
				j++;
			}
		}
		if (j > 0 && j % 2 == 0) {
			return false;
		}
		return res;
	}

}
