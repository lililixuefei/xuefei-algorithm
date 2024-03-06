package leetcode.top100.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 字符串解码
 * @Author xuefei
 * @Date 2024/3/6 22:32
 * @Version 1.0
 */
public class DecodeString {

	public static void main(String[] args) {
		System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
		System.out.println('a');
		System.out.println('z');
	}

	public static String decodeString(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		StringBuilder stringBuilder = new StringBuilder();
		Deque<Character> stack = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ']') {
				stringBuilder = new StringBuilder();
				while (stack.peek() != '[') {
					stringBuilder.append(stack.pop());
				}
				stack.pop();
				StringBuilder countSb = new StringBuilder();
				while (!stack.isEmpty() && (!(stack.peek() >= 'a' && stack.peek() <= 'z') && !(stack.peek() == '['))) {
					countSb.append(stack.pop());
				}
				int count = Integer.parseInt(countSb.reverse().toString());
				String curS = stringBuilder.toString();
				for (int j = 0; j < count - 1; j++) {
					stringBuilder.append(curS);
				}
				curS = stringBuilder.toString();
				for (int j = curS.length() - 1; j >= 0; j--) {
					stack.push(curS.charAt(j));
				}
			} else {
				stack.push(s.charAt(i));
			}
		}
		stringBuilder = new StringBuilder();
		for (Character c : stack) {
			stringBuilder.append(c);
		}
		return stringBuilder.reverse().toString();
	}

}
