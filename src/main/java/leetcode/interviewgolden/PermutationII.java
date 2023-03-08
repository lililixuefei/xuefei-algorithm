package leetcode.interviewgolden;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: 有重复字符串的排列组合
 * @author: xuefei
 * @date: 2023/03/08 23:13
 */
public class PermutationII {

	public static void main(String[] args) {
		System.out.println(permutation("qqe"));
	}

	static StringBuilder stringBuilder = new StringBuilder();

	static Set<String> res = new HashSet<>();


	/**
	 * wrong
	 *
	 * @param S
	 * @return
	 */
	public static String[] permutation(String S) {

		permutation(S.toCharArray(), 0);

		return res.toArray(new String[0]);
	}


	public static void permutation(char[] chars, int start) {
		final String s = stringBuilder.toString();
		if (s.length() == chars.length) {
			res.add(stringBuilder.toString());
			return;
		}

		for (int i = start; i < chars.length; i++) {
			// 剪枝逻辑，值相同的相邻树枝，只遍历第一条
			if (i > start && chars[i] == chars[i - 1]) {
				continue;
			}
			stringBuilder.append(chars[i]);
			permutation(chars, i + 1);
			stringBuilder.deleteCharAt(stringBuilder.toString().length() - 1);
		}
	}
}
