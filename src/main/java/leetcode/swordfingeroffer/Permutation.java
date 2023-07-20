package leetcode.swordfingeroffer;

import java.util.ArrayList;
import java.util.List;

import static zuoshen.course.class17.Code04_PrintAllPermutations.swap;

/**
 * @description: 剑指 Offer 38. 字符串的排列
 * @author: xuefei
 * @date: 2023/07/20 23:17
 */
public class Permutation {

	public static void main(String[] args) {
		Permutation permutation = new Permutation();

		permutation.permutation("acc");
	}

	public String[] permutation(String s) {
		char[] chars = s.toCharArray();
		List<String> ans = new ArrayList<>();
		process(chars, 0, ans);
		return ans.toArray(new String[0]);
	}

	public void process(char[] chars, int i, List<String> ans) {
		if (i == chars.length) {
			ans.add(String.valueOf(chars));
			return;
		}
		boolean[] flag = new boolean[256];
		for (int j = i; j < chars.length; j++) {
			if (!flag[chars[j]]) {
				swap(chars, i, j);
				process(chars, i + 1, ans);
				swap(chars, i, j);
				flag[chars[j]] = true;
			}
		}

	}

	public static void swap(char[] chs, int i, int j) {
		char tmp = chs[i];
		chs[i] = chs[j];
		chs[j] = tmp;
	}


}
