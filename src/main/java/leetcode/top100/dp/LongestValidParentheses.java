package leetcode.top100.dp;

import java.util.Stack;

/**
 * @Description 最长有效括号
 * @Author xuefei
 * @Date 2023/12/24 16:04
 * @Version 1.0
 */
public class LongestValidParentheses {


	public int longestValidParentheses_dp(String s) {
		int maxans = 0;
		int[] dp = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
				} else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
				}
				maxans = Math.max(maxans, dp[i]);
			}
		}
		return maxans;
	}


	public int longestValidParentheses(String s) {
		Stack<Integer> stk = new Stack<>();
		// dp[i] 的定义：记录以 s[i-1] 结尾的最长合法括号子串长度
		int[] dp = new int[s.length() + 1];
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				// 遇到左括号，记录索引
				stk.push(i);
				// 左括号不可能是合法括号子串的结尾
				dp[i + 1] = 0;
			} else {
				// 遇到右括号
				if (!stk.isEmpty()) {
					// 配对的左括号对应索引
					int leftIndex = stk.pop();
					// 以这个右括号结尾的最长子串长度
					int len = 1 + i - leftIndex + dp[leftIndex];
					dp[i + 1] = len;
				} else {
					// 没有配对的左括号
					dp[i + 1] = 0;
				}
			}
		}
		// 计算最长子串的长度
		int res = 0;
		for (int i = 0; i < dp.length; i++) {
			res = Math.max(res, dp[i]);
		}
		return res;
	}

}
