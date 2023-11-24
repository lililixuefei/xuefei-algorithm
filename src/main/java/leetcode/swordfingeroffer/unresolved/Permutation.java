package leetcode.swordfingeroffer.unresolved;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 剑指 Offer 38. 字符串的排列
 * @author: xuefei
 * @date: 2023/07/20 23:17
 */
public class Permutation {


	List<String> res = new ArrayList<>();

	boolean[] visited;

	public String[] permutation(String S) {
		visited = new boolean[S.length()];
		permutation(S.toCharArray(), new LinkedList<>());
		return res.toArray(new String[0]);
	}


	public void permutation(char[] chars, LinkedList<Character> characters) {
		if (characters.size() == chars.length) {
			StringBuilder stringBuilder = new StringBuilder();
			for (Character character : characters) {
				stringBuilder.append(character);
			}
			res.add(stringBuilder.toString());
			return;
		}

		for (int i = 0; i < chars.length; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			characters.add(chars[i]);
			permutation(chars, characters);
			characters.removeLast();
			visited[i] = false;
		}
	}

}
