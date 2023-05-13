package zuoshen.follow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 打印字符串的全排列
 * @author: xuefei
 * @date: 2023/05/13 21:05
 */
public class PrintAllPermutations {

	public static void main(String[] args) {
		PrintAllPermutations printAllPermutations = new PrintAllPermutations();
		printAllPermutations.permutation1("abc");
		printAllPermutations.permutation2("abc");
	}


	public List<String> permutation2(String s) {
		List<String> ans = new ArrayList<>();
		char[] str = s.toCharArray();
		g2(str, 0, ans);
		return ans;
	}

	public void g2(char[] str, int index, List<String> ans) {
		if (index == str.length) {
			ans.add(String.valueOf(str));
		} else {
			boolean[] visited = new boolean[256];
			for (int i = index; i < str.length; i++) {
				if (!visited[str[i]]) {
					visited[str[i]] = true;
					swap(str, index, i);
					g2(str, index + 1, ans);
					swap(str, index, i);
				}
			}
		}
	}

	public void swap(char[] chs, int i, int j) {
		char tmp = chs[i];
		chs[i] = chs[j];
		chs[j] = tmp;
	}


	public void permutation1(String str) {
		boolean[] flag = new boolean[str.length()];
		ArrayList<String> ans = new ArrayList<>();
		process(str.toCharArray(), new LinkedList<>(), ans, flag);

		for (String an : ans) {
			System.out.println(an);
		}

	}

	private void process(char[] chars, List<Character> permutations, List<String> ans, boolean[] flag) {
		if (permutations.size() == chars.length) {
			StringBuilder stringBuilder = new StringBuilder();
			for (Character an : permutations) {
				stringBuilder.append(an);
			}
			ans.add(stringBuilder.toString());
			return;
		}

		for (int i = 0; i < chars.length; i++) {
			if (flag[i]) {
				continue;
			}
			flag[i] = true;
			permutations.add(chars[i]);
			process(chars, permutations, ans, flag);
			permutations.remove(permutations.size() - 1);
			flag[i] = false;
		}

	}

}
