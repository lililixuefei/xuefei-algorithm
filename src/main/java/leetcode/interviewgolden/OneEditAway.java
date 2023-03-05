package leetcode.interviewgolden;


import java.util.*;

/**
 * @description: 一次编辑
 * @author: xuefei
 * @date: 2023/03/05 19:07
 */
public class OneEditAway {

	public static void main(String[] args) {
		oneEditAway("a", "b");
	}

	public static boolean oneEditAway(String a, String b) {
		int n = a.length();
		int m = b.length();
		if (Math.abs(n - m) > 1) {
			return false;
		}
		if (n > m) {
			return oneEditAway(b, a);
		}
		int i = 0;
		int j = 0;
		int cnt = 0;
		while (i < n && j < m && cnt <= 1) {
			char c1 = a.charAt(i);
			char c2 = b.charAt(j);
			if (c1 == c2) {
				i++;
				j++;
			} else {
				if (n == m) {
					i++;
				}
				j++;
				cnt++;
			}
		}
		return cnt <= 1;
	}

	public static boolean oneEditAway_wrong(String first, String second) {

		Map<Character, Integer> map1 = new HashMap<>();
		for (char c : first.toCharArray()) {
			map1.put(c, map1.getOrDefault(c, 0) + 1);
		}

		Map<Character, Integer> map2 = new HashMap<>();
		for (char c : second.toCharArray()) {
			map2.put(c, map2.getOrDefault(c, 0) + 1);
		}

		Set<Character> set = new HashSet<>(map1.keySet());
		for (Character key : set) {
			if (map2.containsKey(key)) {
				Integer count1 = map1.get(key);
				Integer count2 = map2.get(key);
				if (count1 == 1) {
					map1.remove(key);
				} else {
					map1.put(key, count1 - 1);
				}
				if (count2 == 1) {
					map2.remove(key);
				} else {
					map2.put(key, count2 - 1);
				}
			}
		}

		if (map1.size() > 1 || map2.size() > 1) {
			return false;
		}
		return true;
	}

}
