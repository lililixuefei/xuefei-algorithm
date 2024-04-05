package leetcode.top100.ame.stack;

import java.util.Stack;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/5 18:17
 * @Version 1.0
 */
public class IsValid {


	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				char ans = getAns(c);
				if (stack.isEmpty()) {
					return false;
				}
				Character pop = stack.pop();
				if (pop != ans) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	private Character getAns(char c) {
		if (c == ')') {
			return '(';
		}
		if (c == ']') {
			return '[';
		}
		if (c == '}') {
			return '{';
		}
		return null;
	}

}
