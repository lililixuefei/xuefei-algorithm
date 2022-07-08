package a.labuladong;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 有效的括号
 * @author: xuefei
 * @date: 2022/07/09 00:42
 */
public class ValidParentheses {

    public boolean isValid(String str) {
        if (str.length() % 2 == 1){
            return false;
        }

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                if (stack.peek() == leftOf(c)){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private char leftOf(char c) {
        if (c == '}') {
            return '{';
        }
        if (c == ')') {
            return '(';
        }
        return '[';
    }
}
