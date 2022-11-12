package study.wushixiong.firstweek;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 有效的括号
 * @author: xuefei
 * @date: 2022/06/16 23:38
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();

        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            if (c == '(') {
                stack.push('(');
            } else if (c == '[') {
                stack.push('[');
            } else if (c == '{') {
                stack.push('{');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.peek();
                if (top == '(' && c == ')' || top == '[' && c == ']' || top == '{' && c == '}') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
