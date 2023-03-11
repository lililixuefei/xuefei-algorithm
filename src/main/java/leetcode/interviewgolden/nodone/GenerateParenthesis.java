package leetcode.interviewgolden.nodone;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 括号
 * @author: xuefei
 * @date: 2023/03/11 16:34
 */
public class GenerateParenthesis {

	public List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList<>();
		backtrack(ans, new StringBuilder(), 0, 0, n);
		return ans;
	}

	public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
		if (cur.length() == max * 2) {
			ans.add(cur.toString());
			return;
		}
		if (open < max) {
			cur.append('(');
			backtrack(ans, cur, open + 1, close, max);
			cur.deleteCharAt(cur.length() - 1);
		}
		if (close < open) {
			cur.append(')');
			backtrack(ans, cur, open, close + 1, max);
			cur.deleteCharAt(cur.length() - 1);
		}
	}


}
