package xuefei.done.interviewgolden;


import java.util.ArrayList;
import java.util.List;

/**
 * @description: 无重复字符串的排列组合
 * @author: xuefei
 * @date: 2023/03/08 22:56
 */
public class Permutation {

	public static void main(String[] args) {
		permutation("qwe");
	}

	static StringBuilder stringBuilder = new StringBuilder();

	static List<String> res = new ArrayList<>();


	public static String[] permutation(String S) {

		permutation(S.toCharArray(), stringBuilder);

		return res.toArray(new String[0]);
	}


	public static void permutation(char[] chars, StringBuilder stringBuilder) {
		final String s = stringBuilder.toString();
		if (s.length() == chars.length) {
			res.add(stringBuilder.toString());
			return;
		}

		for (int i = 0; i < chars.length; i++) {
			if (s.contains(chars[i] + "")) {
				continue;
			}
			stringBuilder.append(chars[i]);
			permutation(chars, stringBuilder);
			stringBuilder.deleteCharAt(stringBuilder.toString().length() - 1);
		}

	}

}
