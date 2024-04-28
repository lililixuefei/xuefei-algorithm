package leetcode.top100.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 分割回文串
 * @Author xuefei
 * @Date 2024/3/24 19:33
 * @Version 1.0
 */
public class Partition {

	List<List<String>> res = new LinkedList<>();
	LinkedList<String> track = new LinkedList<>();

	public List<List<String>> partition(String s) {
		backtrack(s, 0);
		return res;
	}

	// 回溯算法框架
	void backtrack(String s, int start) {
		if (start == s.length()) {
			// base case，走到叶子节点
			// 即整个 s 被成功分割为若干个回文子串，记下答案
			res.add(new ArrayList<String>(track));
		}
		for (int i = start; i < s.length(); i++) {
			if (!isPalindrome(s, start, i)) {
				// s[start..i] 不是回文串，不能分割
				continue;
			}
			// s[start..i] 是一个回文串，可以进行分割
			// 做选择，把 s[start..i] 放入路径列表中
			track.addLast(s.substring(start, i + 1));
			// 进入回溯树的下一层，继续切分 s[i+1..]
			backtrack(s, i + 1);
			// 撤销选择
			track.removeLast();
		}
	}

	// 用双指针技巧判断 s[lo..hi] 是否是一个回文串
	boolean isPalindrome(String s, int lo, int hi) {
		while (lo < hi) {
			if (s.charAt(lo) != s.charAt(hi)) {
				return false;
			}
			lo++;
			hi--;
		}
		return true;
	}
}
