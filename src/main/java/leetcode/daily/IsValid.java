package leetcode.daily;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 有效的括号
 * @author: xuefei
 * @date: 2023/04/05 18:42
 */
public class IsValid {

	public boolean isValid(String s) {
		Deque<Character> left = new LinkedList<>();
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				left.push(c);
			} else { // 字符 c 是右括号
				if (!left.isEmpty() && leftOf(c) == left.peek()) {
					left.pop();
				} else {
					// 和最近的左括号不匹配
					return false;
				}
			}
		}
		// 是否所有的左括号都被匹配了
		return left.isEmpty();
	}

	char leftOf(char c) {
		if (c == '}') {
			return '{';
		}
		if (c == ')') {
			return '(';
		}
		return '[';
	}

}
