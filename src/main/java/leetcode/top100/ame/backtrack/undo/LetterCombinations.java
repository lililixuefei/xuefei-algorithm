package leetcode.top100.ame.backtrack.undo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/5 18:06
 * @Version 1.0
 */
public class LetterCombinations {


	public static char[][] phone = {
			{'a', 'b', 'c'}, // 2    0
			{'d', 'e', 'f'}, // 3    1
			{'g', 'h', 'i'}, // 4    2
			{'j', 'k', 'l'}, // 5    3
			{'m', 'n', 'o'}, // 6
			{'p', 'q', 'r', 's'}, // 7
			{'t', 'u', 'v'},   // 8
			{'w', 'x', 'y', 'z'}, // 9
	};

	public static List<String> letterCombinations(String digits) {
		List<String> ans = new ArrayList<>();
		if (digits == null || digits.isEmpty()) {
			return ans;
		}
		char[] str = digits.toCharArray();
		char[] path = new char[str.length];
		process(str, 0, path, ans);
		return ans;
	}

	public static void process(char[] str, int index, char[] path, List<String> ans) {
		if (index == str.length) {
			ans.add(String.valueOf(path));
		} else {
			char[] cands = phone[str[index] - '2'];
			for (char cur : cands) {
				path[index] = cur;
				process(str, index + 1, path, ans);
			}
		}
	}

}
